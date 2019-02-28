package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyTranslator {
    public void copyFile(File srcFile,String destDir){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        String fileName = srcFile.getName();
        String destPath = destDir+File.separator+fileName;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(new File (destPath));
            byte[] bs = new byte[1024];
            int count = 0;
            while((count=fis.read(bs))!=-1){
                fos.write(bs,0,count);
                fos.flush();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void copyDiretory(File srcFile,String destDir){
        String dirName = srcFile.getName();
        String destPath = destDir+File.separator+dirName;
        File destDirFile =new File(destPath);
        destDirFile.mkdirs();
        File[] fileList = srcFile.listFiles();
        for (File temp:fileList){
            if (temp.isFile()){
                copyFile(temp,destPath);
            }else if(temp.isDirectory()){
                copyDiretory(temp,destPath);
            }
        }
    }
    public void deleteFile(File file){
        file.delete();
    }
    public boolean deleteDir(File dir){
        if (dir.isDirectory()){
            String[] childern = dir.list();
            for (String temp:childern){
                boolean flag = deleteDir(new File(dir,temp));
                if (flag) {
                    continue;
                }
                return false;
            }
        }
        return dir.delete();
    }
}
