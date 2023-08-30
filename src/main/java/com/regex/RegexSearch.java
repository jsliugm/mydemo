package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSearch {
    public static void main(String[] args) {
        String targetString = "The quick brown fox jumps over the lazy dog.";
        String regexPattern = "\\b[a-z]{5}\\b"; // 匹配5个小写字母单词
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(targetString);
        
        while (matcher.find()) {
            String matchedString = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            System.out.printf("Matched substring: \"%s\" at (%d,%d)\n", matchedString, start, end);
        }
    }
}
