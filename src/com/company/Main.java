package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args){
	// write your code here
        File dir = new File("C:\\Users\\13556\\Desktop\\临时工作区");
        MyClassifer classifer = new MyClassifer(dir);
        File[] dirArray = classifer.getDiceCompressedFile();
        for (File dirName : dirArray) {
            System.out.println(dirName.toString());
        }
    }
}
