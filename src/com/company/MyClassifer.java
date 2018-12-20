package com.company;

import java.io.File;
import java.io.FileFilter;

public class MyClassifer {
    private File dir;
    public MyClassifer(File dir){
        this.dir = dir;
    }

    public File[] getFileDic(){
        FileFilter dirFilter =new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };
        File[] files = this.dir.listFiles(dirFilter);
        return files;
    }

    public File[] getFileTxt(){
        FileFilter txtFileFilter =new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                if(name.endsWith(".txt"))
                    return true;
                else
                    return false;
            }
        };
        File[] files = this.dir.listFiles(txtFileFilter);
        return files;
    }
}
