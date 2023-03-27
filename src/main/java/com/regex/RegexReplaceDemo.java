package com.regex;

import org.junit.Test;

import java.util.regex.*;

public class RegexReplaceDemo {
    public static void main(String[] args) {
        String regex = "(\\d+)-(\\w+)";
        String input = "------aaaaaaa456-def----111111";
        String replacement = "$1-abcdefg";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String result = matcher.replaceAll(replacement);

        System.out.println(result); // output: "123-abcdefg?,456-abcdefg?"
    }

    @Test
    public void test() {
        //"UW_KEY":"aaaabbccddeff"
        //("UW_KEY"\s*:\s*)("\w+")
        String regex = "(\"UW_KEY\"\\s*:\\s*)(\"\\w+\")";
        //{"address":"xxxx","UW_KEY" : "abcdefg","name":"xa"}
        String input = "{\"address\":\"xxxx\",\"UW_KEY\" : \"abcdefg\",\"name\":\"xa\"}";
        String replacement = "$1\"value\"";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String result = matcher.replaceAll(replacement);

        System.out.println(result); // output: "123-abcdefg?,456-abcdefg?"
    }
}
