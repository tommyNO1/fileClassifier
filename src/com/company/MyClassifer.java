package com.company;

import java.io.File;
import java.io.FileFilter;

public class MyClassifer {
    public File[] getFileDic(File dir){
        File[] files = dir.listFiles();
        FileFilter fileFilter =new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };
        files = dir.listFiles(fileFilter);
        return files;
    }
}
