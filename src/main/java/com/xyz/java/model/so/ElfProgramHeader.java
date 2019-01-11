package com.xyz.java.model.so;

import com.xyz.java.model.so.struct.Elf_Addr;
import com.xyz.java.model.so.struct.Elf_Off;
import com.xyz.java.model.so.struct.Elf_Word;
import com.xyz.java.model.so.struct.program.Elf_p_flags;
import com.xyz.java.model.so.struct.program.Elf_p_type;

public class ElfProgramHeader {

    public Elf_p_type elf_p_type = new Elf_p_type();

    public Elf_Off elf_p_offset = new Elf_Off();

    public Elf_Addr elf_p_vaddr = new Elf_Addr();

    public Elf_Addr elf_p_paddr = new Elf_Addr();

    public Elf_Word elf_p_filesz = new Elf_Word();

    public Elf_Word elf_p_memsz = new Elf_Word();

    public Elf_p_flags elf_p_flags = new Elf_p_flags();

    public Elf_Word elf_p_align = new Elf_Word();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("elf_p_type : ").append(elf_p_type.toIntValue()).append("\r\n");
        builder.append("elf_p_offset : ").append(elf_p_offset.toIntValue()).append("\r\n");
        builder.append("elf_p_vaddr : ").append(elf_p_vaddr.toIntValue()).append("\r\n");
        builder.append("elf_p_paddr : ").append(elf_p_paddr.toIntValue()).append("\r\n");
        builder.append("elf_p_filesz : ").append(elf_p_filesz.toIntValue()).append("\r\n");
        builder.append("elf_p_memsz : ").append(elf_p_memsz.toIntValue()).append("\r\n");
        builder.append("elf_p_flags : ").append(elf_p_flags.toIntValue()).append("\r\n");
        builder.append("elf_p_align : ").append(elf_p_align.toIntValue());
        return builder.toString();
    }
}
