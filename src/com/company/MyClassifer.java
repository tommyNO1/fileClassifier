package com.company;

import java.io.File;
import java.io.FileFilter;

public class MyClassifer {
    private File dir;
    public MyClassifer(File dir){
        this.dir = dir;
    }

    public File[] getDicDic(){
        FileFilter dirFilter =new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };
        return this.dir.listFiles(dirFilter);
    }

    public File[] getDicTxtFile(){
        FileFilter txtFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                return name.endsWith(".txt");
            }
        };
        return this.dir.listFiles(txtFileFilter);
    }
    public File[] getDicPPtFile(){
        FileFilter PowerPointFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                return name.endsWith(".ppt") || name.endsWith(".pptx");
            }
        };
        return this.dir.listFiles(PowerPointFileFilter);
    }
    public File[] getDicWordFile(){
        FileFilter wordFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                return name.endsWith(".doc") || name.endsWith(".docx");
            }
        };
        return this.dir.listFiles(wordFileFilter);
    }
    public File[] getDicExcelFile(){
        FileFilter excelFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                    return name.endsWith(".xlsx") || name.endsWith(".xls");
            }
        };
        return this.dir.listFiles(excelFileFilter);
    }
    public File[] getDiceCompressedFile(){
        FileFilter compressedFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                return name.endsWith(".rar") || name.endsWith(".zip") || name.endsWith(".7z");
            }
        };
        return this.dir.listFiles(compressedFileFilter);
    }
}
