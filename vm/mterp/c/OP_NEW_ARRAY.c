HANDLE_OPCODE(OP_NEW_ARRAY /*vA, vB, class@CCCC*/)
    {
        ClassObject* arrayClass;
        ArrayObject* newArray;
        s4 length;

        EXPORT_PC();

        vdst = INST_A(inst);
        vsrc1 = INST_B(inst);       /* length reg */
        ref = FETCH(1);
        ILOGV("|new-array v%d,v%d,class@0x%04x  (%d elements)",
            vdst, vsrc1, ref, (s4) GET_REGISTER(vsrc1));
        length = (s4) GET_REGISTER(vsrc1);
        if (length < 0) {
            dvmThrowException("Ljava/lang/NegativeArraySizeException;", NULL);
            GOTO(exceptionThrown);
        }
        arrayClass = dvmDexGetResolvedClass(methodClassDex, ref);
        if (arrayClass == NULL) {
            arrayClass = dvmResolveClass(method->clazz, ref, false);
            if (arrayClass == NULL)
                GOTO(exceptionThrown);
        }
        /* verifier guarantees this is an array class */
        assert(dvmIsArrayClass(arrayClass));
        assert(dvmIsClassInitialized(arrayClass));

        newArray = dvmAllocArrayByClass(arrayClass, length, ALLOC_DONT_TRACK);
        if (newArray == NULL)
            GOTO(exceptionThrown);
        SET_REGISTER(vdst, (u4) newArray);
    }
    FINISH(2);
OP_END

