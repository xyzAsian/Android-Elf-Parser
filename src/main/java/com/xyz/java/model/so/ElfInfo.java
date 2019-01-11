package com.xyz.java.model.so;

public class ElfInfo {

    private ElfHeader mElfHeader = new ElfHeader();

    private ElfProgramHeader[] mElfProgramHeaders;

    private ElfSectionHeader[] mElfSectionHeaders;

    private ElfDynamicSymbol[] mElfDynamicSymbols;

    public ElfHeader getElfHeader() {
        return mElfHeader;
    }
}
