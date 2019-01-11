package com.xyz.java.model.so;

import com.xyz.java.model.so.struct.Elf_Addr;
import com.xyz.java.model.so.struct.Elf_Off;
import com.xyz.java.model.so.struct.Elf_Word;
import com.xyz.java.model.so.struct.Elf_Xword;
import com.xyz.java.model.so.struct.section.Elf_s_flag;
import com.xyz.java.model.so.struct.section.Elf_s_name;
import com.xyz.java.model.so.struct.section.Elf_s_type;

public class ElfSectionHeader {

    public Elf_s_name elfSName = new Elf_s_name();

    public Elf_s_type elfSType = new Elf_s_type();

    public Elf_s_flag elfSFlag = new Elf_s_flag();

    public Elf_Addr elfSAddr = new Elf_Addr();

    public Elf_Off elfSOffset = new Elf_Off();

    public Elf_Xword elfSSize = new Elf_Xword();

    public Elf_Word elfSLink = new Elf_Word();

    public Elf_Word elfSInfo = new Elf_Word();

    public Elf_Xword elfSAddralign = new Elf_Xword();

    public Elf_Xword elfSEntsize = new Elf_Xword();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("elfSName : ").append(elfSName.toIntValue()).append("\r\n");
        builder.append("elfSType : ").append(elfSType.toIntValue()).append("\r\n");
        builder.append("elfSFlag : ").append(elfSFlag.toIntValue()).append("\r\n");
        builder.append("elfSAddr : ").append(elfSAddr.toIntValue()).append("\r\n");
        builder.append("elfSOffset : ").append(elfSOffset.toIntValue()).append("\r\n");
        builder.append("elfSSize : ").append(elfSSize.toIntValue()).append("\r\n");
        builder.append("elfSLink : ").append(elfSLink.toIntValue()).append("\r\n");
        builder.append("elfSInfo : ").append(elfSInfo.toIntValue()).append("\r\n");
        builder.append("elfSAddralign : ").append(elfSAddralign.toIntValue()).append("\r\n");
        builder.append("elfSEntsize : ").append(elfSEntsize.toIntValue());
        return builder.toString();
    }
}
