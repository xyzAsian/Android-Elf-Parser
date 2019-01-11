package com.xyz.java.model.so.struct;

import com.xyz.java.model.so.struct.BaseElfStruct;

/**
 * ELF 无符号中等大小整数 大小 2 byte
 */
public class Elf_Half extends BaseElfStruct {

    public static final int length = 2;

    @Override
    public int getLength() {
        return length;
    }
}
