package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args){
        MyProperties pps = new MyProperties("G:\\deaProjects\\FileClassifer\\src\\confFile.properties");
//        System.out.println(pps.getPathNamebyPropertiesFile("srcPathName"));
        String srcPath=pps.getPathNamebyPropertiesFile("srcPathName");
        String destPath=pps.getPathNamebyPropertiesFile("destPathName");
        String[] fileType = new String[]{"compress file", "image", "power point", "txt file", "excel","word","pdf","diretory"};
        File dir = new File(srcPath);
        MyClassifer classifer = new MyClassifer(dir);
        File[] fileList = null;
        File destDicFile;
        MyTranslator fileTranslator = new MyTranslator();
        for(String type : fileType){
            String fileDestPath = destPath+File.separator+type;
            switch (type){
                case "compress file":
                    fileList = classifer.getDirCompressedFile();
                    break;
                case "image":
                    fileList = classifer.getDirImageFile();
                    break;
                case "power point":
                    fileList = classifer.getDirPPtFile();
                    break;
                case  "txt file":
                    fileList = classifer.getDirTxtFile();
                    break;
                case "excel":
                    fileList = classifer.getDirExcelFile();
                    break;
                case "word":
                    fileList = classifer.getDirWordFile();
                    break;
                case "pdf":
                    fileList = classifer.getDirPdfFile();
                    break;
                case  "diretory":
                    fileList = classifer.getDirDir();
                    break;
                default:
                    System.out.println("没找到对应的类别");
            }
            destDicFile = new File(fileDestPath);
            destDicFile.mkdirs();
            for(File temp:fileList){
                if (temp.isFile()){
                    fileTranslator.copyFile(temp,fileDestPath);
                    fileTranslator.deleteFile(temp);
                }
                if (temp.isDirectory()){
                    fileTranslator.copyDiretory(temp,fileDestPath);
                    fileTranslator.deleteDir(temp);
                }
            }
        }
    }
}


