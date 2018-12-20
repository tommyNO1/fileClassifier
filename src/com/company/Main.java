package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args){
	// write your code here
        File dir = new File("C:\\Users\\13556\\Desktop\\临时工作区");
        MyClassifer classifer = new MyClassifer(dir);
        File[] dirArray = classifer.getFileTxt();
        for(int i=0;i<dirArray.length;i++){
            File dirName = dirArray[i];
            System.out.println(dirName.toString());
        }
    }
}
