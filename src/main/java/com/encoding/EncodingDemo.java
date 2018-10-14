package com.encoding;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by jsliu on 2018/7/17.
 */
public class EncodingDemo {
    @Test
    public void enLength() throws UnsupportedEncodingException {
        String en ="中";
        System.out.println(en.getBytes("utf-8").length);
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        String b ="中";
        for(int i=0;i<b.length();i++){
           String a = b.substring(i,i+1);
            byte[] bytes = a.getBytes("utf-8");
            System.out.println(bytes.length);
            for(byte bb:bytes){
                //System.out.printf(bb+",");
                System.out.printf("%s %s %s\n",bb,Integer.toHexString(bb),Integer.toBinaryString(bb));
            }
        }

    }
}