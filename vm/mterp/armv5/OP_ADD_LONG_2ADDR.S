%verify "executed"
%include "armv5/binopWide2addr.S" {"preinstr":"adds    r0, r0, r2", "instr":"adc     r1, r1, r3"}
