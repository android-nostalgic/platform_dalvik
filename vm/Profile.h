/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * Android's method call profiling goodies.
 */
#ifndef _DALVIK_PROFILE
#define _DALVIK_PROFILE

#ifndef NOT_VM      /* for utilities that sneakily include this file */

#include <stdio.h>

/* External allocations are hackish enough that it's worthwhile
 * separating them for possible removal later.
 */
#define PROFILE_EXTERNAL_ALLOCATIONS 1

struct Thread;      // extern


/* boot init */
bool dvmProfilingStartup(void);
void dvmProfilingShutdown(void);

/*
 * Method trace state.  This is currently global.  In theory we could make
 * most of this per-thread.
 *
 */
typedef struct MethodTraceState {
    /* these are set during VM init */
    Method* gcMethod;
    Method* classPrepMethod;

    /* active state */
    pthread_mutex_t startStopLock;
    pthread_cond_t  threadExitCond;
    FILE*   traceFile;
    int     bufferSize;
    int     flags;

    bool    traceEnabled;
    u1*     buf;
    volatile int curOffset;
    u8      startWhen;
    int     overflow;
} MethodTraceState;

/*
 * Memory allocation profiler state.  This is used both globally and
 * per-thread.
 *
 * If you add a field here, zero it out in dvmStartAllocCounting().
 */
typedef struct AllocProfState {
    bool    enabled;            // is allocation tracking enabled?

    int     allocCount;         // #of objects allocated
    int     allocSize;          // cumulative size of objects

    int     failedAllocCount;   // #of times an allocation failed
    int     failedAllocSize;    // cumulative size of failed allocations

    int     freeCount;          // #of objects freed
    int     freeSize;           // cumulative size of freed objects

    int     gcCount;            // #of times an allocation triggered a GC

#if PROFILE_EXTERNAL_ALLOCATIONS
    int     externalAllocCount; // #of calls to dvmTrackExternalAllocation()
    int     externalAllocSize;  // #of bytes passed to ...ExternalAllocation()

    int     failedExternalAllocCount; // #of times an allocation failed
    int     failedExternalAllocSize;  // cumulative size of failed allocations

    int     externalFreeCount;  // #of calls to dvmTrackExternalFree()
    int     externalFreeSize;   // #of bytes passed to ...ExternalFree()
#endif  // PROFILE_EXTERNAL_ALLOCATIONS
} AllocProfState;


/*
 * Start/stop method tracing.
 */
void dvmMethodTraceStart(const char* traceFileName, int bufferSize, int flags);
void dvmMethodTraceStop(void);

/*
 * Start/stop emulator tracing.
 */
void dvmEmulatorTraceStart(void);
void dvmEmulatorTraceStop(void);

/*
 * Start/stop Dalvik instruction counting.
 */
void dvmStartInstructionCounting();
void dvmStopInstructionCounting();

/*
 * Bit flags for dvmMethodTraceStart "flags" argument.  These must match
 * the values in android.os.Debug.
 */
enum {
    TRACE_ALLOC_COUNTS      = 0x01,
};

/*
 * Call these when a method enters or exits.
 */
#ifdef WITH_PROFILER
# define TRACE_METHOD_ENTER(_self, _method)                                 \
    do {                                                                    \
        if (gDvm.activeProfilers != 0) {                                    \
            if (gDvm.methodTrace.traceEnabled)                              \
                dvmMethodTraceAdd(_self, _method, METHOD_TRACE_ENTER);      \
            if (gDvm.emulatorTraceEnableCount != 0)                         \
                dvmEmitEmulatorTrace(_method, METHOD_TRACE_ENTER);          \
        }                                                                   \
    } while(0);
# define TRACE_METHOD_EXIT(_self, _method)                                  \
    do {                                                                    \
        if (gDvm.activeProfilers != 0) {                                    \
            if (gDvm.methodTrace.traceEnabled)                              \
                dvmMethodTraceAdd(_self, _method, METHOD_TRACE_EXIT);       \
            if (gDvm.emulatorTraceEnableCount != 0)                         \
                dvmEmitEmulatorTrace(_method, METHOD_TRACE_EXIT);           \
        }                                                                   \
    } while(0);
# define TRACE_METHOD_UNROLL(_self, _method)                                \
    do {                                                                    \
        if (gDvm.activeProfilers != 0) {                                    \
            if (gDvm.methodTrace.traceEnabled)                              \
                dvmMethodTraceAdd(_self, _method, METHOD_TRACE_UNROLL);     \
            if (gDvm.emulatorTraceEnableCount != 0)                         \
                dvmEmitEmulatorTrace(_method, METHOD_TRACE_UNROLL);         \
        }                                                                   \
    } while(0);
#else
# define TRACE_METHOD_ENTER(_self, _method)     ((void) 0)
# define TRACE_METHOD_EXIT(_self, _method)      ((void) 0)
# define TRACE_METHOD_UNROLL(_self, _method)    ((void) 0)
#endif

void dvmMethodTraceAdd(struct Thread* self, const Method* method, int action);
void dvmEmitEmulatorTrace(const Method* method, int action);

void dvmMethodTraceGCBegin(void);
void dvmMethodTraceGCEnd(void);
void dvmMethodTraceClassPrepBegin(void);
void dvmMethodTraceClassPrepEnd(void);

/*
 * Start/stop alloc counting.
 */
void dvmStartAllocCounting(void);
void dvmStopAllocCounting(void);

#endif


/*
 * Enumeration for the two "action" bits.
 */
enum {
    METHOD_TRACE_ENTER = 0x00,      // method entry
    METHOD_TRACE_EXIT = 0x01,       // method exit
    METHOD_TRACE_UNROLL = 0x02,     // method exited by exception unrolling
    // 0x03 currently unused
};

#define TOKEN_CHAR      '*'
#define TRACE_VERSION   1

/*
 * Common definitions, shared with the dump tool.
 */
#define METHOD_ACTION_MASK      0x03            /* two bits */
#define METHOD_ID(_method)      ((_method) & (~METHOD_ACTION_MASK))
#define METHOD_ACTION(_method)  (((unsigned int)(_method)) & METHOD_ACTION_MASK)
#define METHOD_COMBINE(_method, _action)    ((_method) | (_action))

#endif /*_DALVIK_PROFILE*/
