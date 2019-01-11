package com.xyz.java.model.so;

import com.xyz.java.model.so.struct.Elf_Addr;
import com.xyz.java.model.so.struct.Elf_Half;
import com.xyz.java.model.so.struct.header.Elf_Ident;
import com.xyz.java.model.so.struct.Elf_Off;
import com.xyz.java.model.so.struct.Elf_Word;

public class ElfHeader {

    //魔数
    private Elf_Ident e_ident = new Elf_Ident();

    //标识的是该文件的类型
    private Elf_Half e_type = new Elf_Half();

    //运行该程序需要的体系结构
    private Elf_Half e_machine = new Elf_Half();

    //文件的版本
    private Elf_Word e_version = new Elf_Word();

    //程序的入口地址
    private Elf_Addr e_entry = new Elf_Addr();

    //表示Program header table 在文件中的偏移量（以字节计数）
    private Elf_Off e_phoff = new Elf_Off();

    //表示Section header table 在文件中的偏移量（以字节计数）
    private Elf_Off e_shoff = new Elf_Off();

    //对IA32而言，此项为0
    private Elf_Word e_flags = new Elf_Word();

    //表示ELF header大小（以字节计数）
    private Elf_Half e_ehsize = new Elf_Half();

    //表示Program header table中每一个条目的大小
    private Elf_Half e_phentsize = new Elf_Half();

    //表示Program header table中有多少个条目
    private Elf_Half e_phnum = new Elf_Half();

    //表示Section header table中的每一个条目的大小
    private Elf_Half e_shentsize = new Elf_Half();

    //表示Section header table中有多少个条目
    private Elf_Half e_shnum = new Elf_Half();

    //包含节名称的字符串是第几个节（从零开始计数）
    private Elf_Half e_shtrndx = new Elf_Half();

    public Elf_Ident getE_ident() {
        return e_ident;
    }

    public Elf_Half getE_type() {
        return e_type;
    }

    public Elf_Half getE_machine() {
        return e_machine;
    }

    public Elf_Word getE_version() {
        return e_version;
    }

    public Elf_Addr getE_entry() {
        return e_entry;
    }

    public Elf_Off getE_phoff() {
        return e_phoff;
    }

    public Elf_Off getE_shoff() {
        return e_shoff;
    }

    public Elf_Word getE_flags() {
        return e_flags;
    }

    public Elf_Half getE_ehsize() {
        return e_ehsize;
    }

    public Elf_Half getE_phentsize() {
        return e_phentsize;
    }

    public Elf_Half getE_phnum() {
        return e_phnum;
    }

    public Elf_Half getE_shentsize() {
        return e_shentsize;
    }

    public Elf_Half getE_shnum() {
        return e_shnum;
    }

    public Elf_Half getE_shtrndx() {
        return e_shtrndx;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("e_ident : ").append(e_ident.toStringValue()).append("\r\n");
        builder.append("e_type : ").append(e_type.toIntValue()).append("\r\n");
        builder.append("e_machine : ").append(e_machine.toIntValue()).append("\r\n");
        builder.append("e_version : ").append(e_version.toIntValue()).append("\r\n");
        builder.append("e_entry : ").append(e_entry.toIntValue()).append("\r\n");
        builder.append("e_phoff : ").append(e_phoff.toIntValue()).append("\r\n");
        builder.append("e_shoff : ").append(e_shoff.toIntValue()).append("\r\n");
        builder.append("e_flags : ").append(e_flags.toIntValue()).append("\r\n");
        builder.append("e_ehsize : ").append(e_ehsize.toIntValue()).append("\r\n");
        builder.append("e_phentsize : ").append(e_phentsize.toIntValue()).append("\r\n");
        builder.append("e_phnum : ").append(e_phnum.toIntValue()).append("\r\n");
        builder.append("e_shentsize : ").append(e_shentsize.toIntValue()).append("\r\n");
        builder.append("e_shnum : ").append(e_shnum.toIntValue()).append("\r\n");
        builder.append("e_shtrndx : ").append(e_shtrndx.toIntValue());
        return builder.toString();
    }
}
