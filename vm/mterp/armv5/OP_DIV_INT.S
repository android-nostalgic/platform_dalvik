%verify "executed"
%include "armv5/binop.S" {"instr":"bl     __aeabi_idiv","chkzero":"1"}
