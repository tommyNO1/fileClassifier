package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args){
	// write your code here
        String srcPath="C:\\Users\\13556\\Desktop\\临时工作区";
        String destPath="F:\\test";
        String[] fileType = new String[]{"compress file", "image", "power point", "txt file", "excel","word","pdf","diretory"};
        File dir = new File(srcPath);
        MyClassifer classifer = new MyClassifer(dir);
        File[] fileList = null;
        File destDicFile;
        MyTranslocator fileTranslocator = new MyTranslocator();
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
                    fileTranslocator.copyFile(temp,fileDestPath);
                    fileTranslocator.deleteFile(temp);
                }
                if (temp.isDirectory()){
                    fileTranslocator.copyDiretory(temp,fileDestPath);
                    fileTranslocator.deleteDir(temp);
                }
            }
        }
    }
}


