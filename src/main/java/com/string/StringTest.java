package com.string;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.swing.CodeDialog;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.regex.Pattern;

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
    public void test3() {
        String a = "xxx";
        String[] arr = a.split(",");
        System.out.println(arr[0]);
    }

    @Test
    public void test4() {
        String a = "xxx";
        String[] arr = a.split(",");
        System.out.println(StringUtils.isBlank("    "));
    }

    @Test
    public void test5() {
        BigDecimal b2 = BigDecimal.valueOf(2);
        BigDecimal b3 = BigDecimal.valueOf(3);
        //System.out.println(b2.subtract(b3));
        System.out.println(b2.divide(b3, 0, BigDecimal.ROUND_HALF_DOWN));
    }

    @Test
    public void test6() {
        StringBuffer stringBuffer = new StringBuffer("zhongguo ren 1中国");
        stringBuffer.delete(stringBuffer.lastIndexOf("中国"), stringBuffer.length());
        System.out.println(stringBuffer);

    }

    @Test
    public void test7() {
        for (int i = 0; i < 100; i++) {
            System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        }
    }

    @Test
    public void test8() {
        String f = "12%s12";
        System.out.println(String.format(f, "abc"));
    }

    @Test
    public void test9() {
        String[] xxx = {"a", "b", "c", "d"};
        int len = xxx.length;
        for (int cur = 1; cur < (1 << len); cur++)  //遍历所有的情况，1<<len就等于2^len，遍历1 ~ 2^len-1
        {
            //System.out.println(cur);
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < len; j++)  //遍历所有的字符
            {
                if ((cur & (1 << j)) > 0)   //判断哪一位为1，即输出该位
                {
                    sb.append(xxx[j]);
                }
            }
            System.out.println(sb);
        }
    }

    private String genSubKey(String[] xx, int parentkey) {
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < xx.length; j++)  //遍历所有的字符
        {
            if ((parentkey & (1 << j)) > 0)   //判断哪一位为1，即输出该位
            {
                sb.append(xx[j]);
            }
        }
        return sb.toString();
    }

    private Integer genParentKey(String[] customerList) {
        //
        Integer key = 0;
        for (int i = 0; i < customerList.length; i++) {
            if (customerList[i] != null) {
                key = key + (1 << i);
            }
        }
        return key;
    }


    @Test
    public void testGenParentKey() {
        //String[] xxx = {"a", "b", "c","d"};
        List<String> customerList = Lists.newArrayList(null, null, null, null);
        //System.out.println(genParentKey(customerList));
    }

    @Test
    public void testGenSubKey() {
        String[] xxx = {"a", "b", "c", "d"};
        System.out.println(genSubKey(xxx, 0));
    }


    public void xxx(String str, String encoding) {
        try {
            byte[] b2 = encoding == null ? str.getBytes() : str.getBytes(encoding);
            for (byte b : b2) {
                System.out.print(b);
            }
            System.out.println(new String(b2, "gbk"));
            System.out.println();
        } catch (UnsupportedEncodingException e) {
        }
    }

    @Test
    public void subStringTest() {
        String aaa = "1234567";

        System.out.println(aaa.substring(3));

        System.out.println(aaa.substring(0, aaa.indexOf("3")));

        System.out.println(aaa.substring(aaa.indexOf("3")));
    }

    @Test
    public void refrenceTest() {
        String aa = "aaaaaa";

        println(aa);
        System.out.println(aa.hashCode());
    }
    @Test
    public void testJoin(){
        StringJoiner sj = new StringJoiner(" && ");
        sj.add("xxx");
        System.out.println(sj.length());
        System.out.println(sj.toString());
    }

    private void println(String aa) {
        System.out.println(aa.hashCode());
    }
    @Test
    public void test17(){
        System.out.printf("[%d]\n",123);
        System.out.printf("[%4d]\n",123);
        System.out.printf("[%-4d]\n",123);
        System.out.printf("[%04d]\n",123);
        System.out.printf("[%d]\n",123);
    }
    @Test
    public void test18(){
        String jj = "";
        if(jj instanceof String) {
            System.out.println("yyyyyyyyes");
        }
    }
    @Test
    public void test19(){
        String pattern = "{return '%s' }()" ;
        String nullPattern = "{return null }()" ;
        System.out.println(nullPattern);
        System.out.println(String.format(pattern,"1"));
    }
    @Test
    public void test202(){
        Pattern pattern = Pattern.compile("^.*\\[交\\b.*$");
        String target = "[交]信息";
        System.out.println(pattern.matcher(target).matches());
    }
    static Map<String,String> map = Maps.newHashMap();
    @Test
    public void test210(){
        map.put("1","1");
        Map<String,String> map = Maps.newHashMap();
        List<String> list = Lists.newArrayList("1","2");
        list.forEach(
                it->{
                    map.put(it,it);
                }
        );

        System.out.println(StringTest.map);
        System.out.println(map);
    }
}