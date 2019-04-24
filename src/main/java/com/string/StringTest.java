package com.string;

import com.swing.CodeDialog;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.UUID;

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
    @Test
    public void test3(){
        String a = "xxx";
        String[] arr = a.split(",");
        System.out.println(arr[0]);
    }

    @Test
    public void test4(){
        String a = "xxx";
        String[] arr = a.split(",");
        System.out.println(StringUtils.isBlank("    "));
    }
    @Test
    public void test5(){
        BigDecimal b2 = BigDecimal.valueOf(2);
        BigDecimal b3 = BigDecimal.valueOf(3);
        //System.out.println(b2.subtract(b3));
        System.out.println(b2.divide(b3,0,BigDecimal.ROUND_HALF_DOWN));
    }
    @Test
    public void test6(){
        StringBuffer stringBuffer = new StringBuffer("zhongguo ren 1中国");
        stringBuffer.delete(stringBuffer.lastIndexOf("中国"),stringBuffer.length());
        System.out.println(stringBuffer);

    }
    @Test
    public void test7(){
        for(int i=0;i<100;i++)
        {System.out.println(UUID.randomUUID().toString().replaceAll("-",""));}
    }
    @Test
    public void test8(){
        String f = "12%s12";
        System.out.println(String.format(f,"abc"));
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