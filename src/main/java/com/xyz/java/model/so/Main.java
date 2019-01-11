package com.xyz.java.model.so;

import com.xyz.java.model.so.struct.Elf_Half;
import com.xyz.java.model.so.struct.header.Elf_Ident;
import com.xyz.java.model.util.FileIOUtils;

import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        String soFilePath = "F:\\libmd5.so";
        File soFile = new File(soFilePath);
        byte[] bytes = FileIOUtils.readFile2BytesByStream(soFile);

        ElfInfo elfInfo = new ElfInfo();
        try {
            readElfHeader(elfInfo.getElfHeader(), bytes);
            System.out.println(elfInfo.getElfHeader());

            ElfSectionHeader[] elfSectionHeaders = readElfSectionHeader(elfInfo.getElfHeader(), bytes);
            System.out.println(elfSectionHeaders[0]);

            ElfProgramHeader[] elfProgramHeaders = readElfProgramHeader(elfInfo.getElfHeader(), bytes);
            System.out.println(elfProgramHeaders[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取 Elf 文件 header
     * @param elfHeader
     * @param fileBytes
     * @return
     * @throws IndexOutOfBoundsException
     */
    private static ElfHeader readElfHeader(ElfHeader elfHeader, byte[] fileBytes) throws IndexOutOfBoundsException {

        int cursor = 0;
        elfHeader.getE_ident().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + Elf_Ident.length));
        cursor += Elf_Ident.length;

        elfHeader.getE_type().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_type().getLength()));
        cursor += elfHeader.getE_type().getLength();

        elfHeader.getE_machine().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_machine().getLength()));
        cursor += elfHeader.getE_machine().getLength();

        elfHeader.getE_version().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_version().getLength()));
        cursor += elfHeader.getE_version().getLength();

        elfHeader.getE_entry().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_entry().getLength()));
        cursor += elfHeader.getE_entry().getLength();

        elfHeader.getE_phoff().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_phoff().getLength()));
        cursor += elfHeader.getE_phoff().getLength();

        elfHeader.getE_shoff().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_shoff().getLength()));
        cursor += elfHeader.getE_shoff().getLength();

        elfHeader.getE_flags().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_flags().getLength()));
        cursor += elfHeader.getE_flags().getLength();

        elfHeader.getE_ehsize().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_ehsize().getLength()));
        cursor += elfHeader.getE_ehsize().getLength();

        elfHeader.getE_phentsize().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_phentsize().getLength()));
        cursor += elfHeader.getE_phentsize().getLength();

        elfHeader.getE_phnum().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_phnum().getLength()));
        cursor += elfHeader.getE_phnum().getLength();

        elfHeader.getE_shentsize().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_shentsize().getLength()));
        cursor += elfHeader.getE_shentsize().getLength();

        elfHeader.getE_shnum().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_shnum().getLength()));
        cursor += elfHeader.getE_shnum().getLength();

        elfHeader.getE_shtrndx().setValue(Arrays.copyOfRange(fileBytes, cursor, cursor + elfHeader.getE_shtrndx().getLength()));
//        cursor += elfHeader.getE_shtrndx().getLength();

        return elfHeader;
    }

    /**
     * 读取 Elf 节头 Section
     * @param elfHeader
     * @param fileBytes
     * @return
     * @throws IndexOutOfBoundsException
     */
    private static ElfSectionHeader[] readElfSectionHeader(ElfHeader elfHeader, byte[] fileBytes) throws IndexOutOfBoundsException {
        int e_shentsize = elfHeader.getE_shentsize().toIntValue();//每一个条目的大小
        int e_shnum = elfHeader.getE_shnum().toIntValue();//有多少个条目
        int e_shoff = elfHeader.getE_shoff().toIntValue();//在文件中的偏移量（以字节计数）

        ElfSectionHeader[] elfSectionHeaders = new ElfSectionHeader[e_shnum];
        for (int i = 0; i < e_shnum; i++) {
            elfSectionHeaders[i] = new ElfSectionHeader();
            int cursor = e_shoff + (i * e_shentsize);
            elfSectionHeaders[i].elfSName.setValue(Arrays.copyOfRange(fileBytes, cursor, cursor += elfSectionHeaders[i].elfSName.getLength()));
            elfSectionHeaders[i].elfSType.setValue(Arrays.copyOfRange(fileBytes, cursor, cursor += elfSectionHeaders[i].elfSType.getLength()));
            elfSectionHeaders[i].elfSFlag.setValue(Arrays.copyOfRange(fileBytes, cursor, cursor += elfSectionHeaders[i].elfSFlag.getLength()));
            elfSectionHeaders[i].elfSAddr.setValue(Arrays.copyOfRange(fileBytes, cursor, cursor += elfSectionHeaders[i].elfSAddr.getLength()));
            elfSectionHeaders[i].elfSOffset.setValue(Arrays.copyOfRange(fileBytes, cursor, cursor += elfSectionHeaders[i].elfSOffset.getLength()));
            elfSectionHeaders[i].elfSSize.setValue(Arrays.copyOfRange(fileBytes, cursor, cursor += elfSectionHeaders[i].elfSSize.getLength()));
            elfSectionHeaders[i].elfSLink.setValue(Arrays.copyOfRange(fileBytes, cursor, cursor += elfSectionHeaders[i].elfSLink.getLength()));
            elfSectionHeaders[i].elfSInfo.setValue(Arrays.copyOfRange(fileBytes, cursor, cursor += elfSectionHeaders[i].elfSInfo.getLength()));
            elfSectionHeaders[i].elfSAddralign.setValue(Arrays.copyOfRange(fileBytes, cursor, cursor += elfSectionHeaders[i].elfSAddralign.getLength()));
            elfSectionHeaders[i].elfSEntsize.setValue(Arrays.copyOfRange(fileBytes, cursor, cursor += elfSectionHeaders[i].elfSEntsize.getLength()));
        }
        return elfSectionHeaders;
    }

    /**
     * 读取 Elf 程序头 Program
     * @param elfHeader
     * @param fileBytes
     * @return
     */
    private static ElfProgramHeader[] readElfProgramHeader(ElfHeader elfHeader, byte[] fileBytes) {

        int phentsize = elfHeader.getE_phentsize().toIntValue();
        int phnum = elfHeader.getE_phnum().toIntValue();
        int phoff = elfHeader.getE_phoff().toIntValue();

        ElfProgramHeader[] elfProgramHeaders = new ElfProgramHeader[phnum];
        for (int i = 0; i < phnum; i++) {
            int cursor = phoff + (i * phentsize);
            elfProgramHeaders[i] = new ElfProgramHeader();
            elfProgramHeaders[i].elf_p_type.setValue(Arrays.copyOfRange(fileBytes,cursor, cursor+=elfProgramHeaders[i].elf_p_type.getLength()));
            elfProgramHeaders[i].elf_p_offset.setValue(Arrays.copyOfRange(fileBytes,cursor, cursor+=elfProgramHeaders[i].elf_p_offset.getLength()));
            elfProgramHeaders[i].elf_p_vaddr.setValue(Arrays.copyOfRange(fileBytes,cursor, cursor+=elfProgramHeaders[i].elf_p_vaddr.getLength()));
            elfProgramHeaders[i].elf_p_paddr.setValue(Arrays.copyOfRange(fileBytes,cursor, cursor+=elfProgramHeaders[i].elf_p_paddr.getLength()));
            elfProgramHeaders[i].elf_p_filesz.setValue(Arrays.copyOfRange(fileBytes,cursor, cursor+=elfProgramHeaders[i].elf_p_filesz.getLength()));
            elfProgramHeaders[i].elf_p_memsz.setValue(Arrays.copyOfRange(fileBytes,cursor, cursor+=elfProgramHeaders[i].elf_p_memsz.getLength()));
            elfProgramHeaders[i].elf_p_flags.setValue(Arrays.copyOfRange(fileBytes,cursor, cursor+=elfProgramHeaders[i].elf_p_flags.getLength()));
            elfProgramHeaders[i].elf_p_align.setValue(Arrays.copyOfRange(fileBytes,cursor, cursor+=elfProgramHeaders[i].elf_p_align.getLength()));
        }
        return elfProgramHeaders;
    }
}
