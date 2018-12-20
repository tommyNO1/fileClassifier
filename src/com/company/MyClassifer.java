package com.company;

import java.io.File;
import java.io.FileFilter;

public class MyClassifer {
    private File dir;
    public MyClassifer(File dir){
        this.dir = dir;
    }
    public File[] getFileDic(){
        FileFilter fileFilter =new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };
        File[] files = this.dir.listFiles(fileFilter);
        return files;
    }
}
