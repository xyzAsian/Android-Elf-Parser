package com.xyz.java.model.so.struct.header;

import com.xyz.java.model.so.struct.BaseElfStruct;

/**
 * ELF 无符号中等大小整数 大小 2 byte
 */
public class Elf_Ident extends BaseElfStruct {

    public static final int length = 16;

    @Override
    public int getLength() {
        return length;
    }
}
