package com.swing;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @program: MyDemo
 * @description: 测试
 * @author: guangming.liu
 * @create: 2018-10-09 09:25
 **/
public class CodeDialogTest {
    @Test
    public void test() throws UnsupportedEncodingException {
        CodeDialog codeDialog = new CodeDialog();
        String rr = codeDialog.showDialog();
        byte[] bytes = rr.getBytes("utf-8");
        System.out.println(bytes.length);
    }
}