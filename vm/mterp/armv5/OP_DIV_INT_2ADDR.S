%verify "executed"
%include "armv5/binop2addr.S" {"instr":"bl     __aeabi_idiv","chkzero":"1"}
