%verify "executed"
/* must be "mul r0, r1, r0" -- "r0, r0, r1" is illegal */
%include "armv5/binopLit8.S" {"instr":"mul     r0, r1, r0"}
