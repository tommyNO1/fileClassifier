package com.company;

import java.io.File;
import java.io.FileFilter;

public class MyClassifer {
    private File dir;
    public MyClassifer(File dir){
        this.dir = dir;
    }

    public File[] getDirDir(){
        FileFilter dirFilter =new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };
        return this.dir.listFiles(dirFilter);
    }

    public File[] getDirTxtFile(){
        FileFilter txtFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                return name.endsWith(".txt");
            }
        };
        return this.dir.listFiles(txtFileFilter);
    }
    public File[] getDirPPtFile(){
        FileFilter PowerPointFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                return name.endsWith(".ppt") || name.endsWith(".pptx");
            }
        };
        return this.dir.listFiles(PowerPointFileFilter);
    }
    public File[] getDirWordFile(){
        FileFilter wordFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                return name.endsWith(".doc") || name.endsWith(".docx");
            }
        };
        return this.dir.listFiles(wordFileFilter);
    }
    public File[] getDirExcelFile(){
        FileFilter excelFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                    return name.endsWith(".xlsx") || name.endsWith(".xls");
            }
        };
        return this.dir.listFiles(excelFileFilter);
    }
    public File[] getDirCompressedFile(){
        FileFilter compressedFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                return name.endsWith(".rar") || name.endsWith(".zip") || name.endsWith(".7z");
            }
        };
        return this.dir.listFiles(compressedFileFilter);
    }
    public File[] getDirImageFile(){
        FileFilter imageFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                return name.endsWith(".png") || name.endsWith(".bwp") || name.endsWith("jpg")|| name.endsWith("tif");
            }
        };
        return this.dir.listFiles(imageFileFilter);
    }
    public File[] getDirPdfFile(){
        FileFilter pdfFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                return name.endsWith(".pdf");
            }
        };
        return this.dir.listFiles(pdfFileFilter);
    }
}
