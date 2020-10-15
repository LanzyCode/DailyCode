package com.lanzycode.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderDemo {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        InputStream is = cl.getResourceAsStream("prop.properties");
        properties.load(is);
        System.out.println(properties);
        is.close();
    }
}
