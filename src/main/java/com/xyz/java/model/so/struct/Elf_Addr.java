package com.xyz.java.model.so.struct;

import com.xyz.java.model.so.struct.BaseElfStruct;

/**
 * ELF 无符号程序地址 大小 4 byte
 */
public class Elf_Addr extends BaseElfStruct {

    public static final int length = 4;

    @Override
    public int getLength() {
        return length;
    }
}
