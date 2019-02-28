package com.company;

import java.io.*;
import java.util.Properties;

public class MyProperties {
    private String path;
    public MyProperties(String path){this.path = path;}
    public String getPathNamebyPropertiesFile(String key){
        Properties pps = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(path));
            pps.load(new InputStreamReader(in,"utf-8"));
            String value = pps.getProperty(key);
            return value;
        }catch (IOException e){
            e.printStackTrace();;
            return null;
        }
    }
}
