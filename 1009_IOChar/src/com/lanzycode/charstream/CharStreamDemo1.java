package com.lanzycode.charstream;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharStreamDemo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Encode();
        DeCode();
    }

    private static void DeCode() throws UnsupportedEncodingException {
        byte[] bytes={-54,-19,-58,-84};
        String s=new String(bytes,"GBK");
        System.out.println(s);
    }

    private static void Encode() throws UnsupportedEncodingException {
        String s="烧烤";
        byte[] bytes=s.getBytes("GBK");
        System.out.println(Arrays.toString(bytes));
    }
}
