package com.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.fail;

public class RegexTest {

    // @Test
    public void test() {
        fail("Not yet implemented");
    }

    //@Test
    public void test1() {
        String str = "if a>1";
        String regexPat = "\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")"
                + "|[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";
        Pattern p = Pattern.compile(regexPat);

        Matcher m = p.matcher(str);
        while (m.find())
            System.out.println(m.group());
    }

    @Test
    public void test2() {
        String input = "222222abcdef1111";
        String strPattern = "[a-zA-Z]+";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(input);

        if (m.find()) {
            //System.out.println(m.group());
            System.out.println(m.start());
            System.out.println(m.end());
        }
    }

    @Test
    public void test3() {
        String pattern = "^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])\\s+(20|21|22|23|[0-1]\\d):[0-5]\\d:[0-5]\\d$";
        Pattern p = Pattern.compile(pattern);
        System.out.println(p.matcher("2020-2-29 02:02:02").find());
    }

    @Test
    public void test4() {
        String txt = "Rule123.class.Rule345.xx";
        Pattern p = Pattern.compile("Rule\\w+");
        Matcher matcher = p.matcher(txt);
        if(matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

}
