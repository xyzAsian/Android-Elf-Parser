package com.xyz.java.model.so.struct.section;

import com.xyz.java.model.so.struct.BaseElfStruct;

public class Elf_s_type extends BaseElfStruct {

    public static final int length = 4;

    @Override
    public int getLength() {
        return length;
    }
}
