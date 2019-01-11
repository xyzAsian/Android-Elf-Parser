package com.xyz.java.model.so.struct;

import com.xyz.java.model.so.struct.BaseElfStruct;

/**
 * ELF 无符号大整数 大小 4 byte
 */
public class Elf_Word extends BaseElfStruct {

    public static final int length = 4;

    @Override
    public int getLength() {
        return length;
    }
}
