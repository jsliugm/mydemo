package com.string;

import com.swing.CodeDialog;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @program: MyDemo
 * @description:
 * @author: guangming.liu
 * @create: 2018-09-17 12:50
 **/
public class StringTest {
    @Test
    public void test() {
        String input = new CodeDialog().showDialog();
        System.out.println(input);
    }

    @Test
    public void test2() throws UnsupportedEncodingException {
        String a = "中国";
        xxx(a, null);
        xxx(a, "utf-8");
        xxx(a, "gbk");
        xxx(a, "gb18030");
        xxx(a, "gb2312");
    }

    public void xxx(String str, String encoding) {
        try {
            byte[] b2 = encoding == null ? str.getBytes() : str.getBytes(encoding);
            for (byte b : b2) {
                System.out.print(b);
            }
            System.out.println(new String(b2,"gbk"));
            System.out.println();
        } catch (UnsupportedEncodingException e) {
        }
    }

}