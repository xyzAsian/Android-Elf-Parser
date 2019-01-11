package com.xyz.java.model.so.struct;

/**
 * ELF 有符号大整数 大小 4 byte
 */
public class Elf_Xword extends BaseElfStruct {

    public static final int length = 4;

    @Override
    public int getLength() {
        return length;
    }
}
