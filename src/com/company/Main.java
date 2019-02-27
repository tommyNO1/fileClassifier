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
                    fileList = classifer.getDicCompressedFile();
                    break;
                case "image":
                    fileList = classifer.getDicImageFile();
                    break;
                case "power point":
                    fileList = classifer.getDicPPtFile();
                    break;
                case  "txt file":
                    fileList = classifer.getDicTxtFile();
                    break;
                case "excel":
                    fileList = classifer.getDicExcelFile();
                    break;
                case "word":
                    fileList = classifer.getDicWordFile();
                    break;
                case "pdf":
                    fileList = classifer.getDicPdfFile();
                    break;
                case  "diretory":
                    fileList = classifer.getDicDic();
                    break;
                default:
                    System.out.println("没找到对应的类别");
            }
            destDicFile = new File(fileDestPath);
            destDicFile.mkdirs();
            for(File temp:fileList){
                if (temp.isFile()){
                    fileTranslocator.copyFile(temp,fileDestPath);
                }
                if (temp.isDirectory()){
                    fileTranslocator.copyDiretory(temp,fileDestPath);
                }
            }
        }
    }
}


