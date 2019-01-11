package com.xyz.java.model.so.struct.program;

import com.xyz.java.model.so.struct.BaseElfStruct;

public class Elf_p_type extends BaseElfStruct {

    public static final int length = 4;

    @Override
    public int getLength() {
        return length;
    }
}
