package com.lanzycode.prop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("王宝强","马蓉");
        properties.setProperty("贾乃亮","李小璐");
        properties.setProperty("潘金莲","武大郎");
    }
}
