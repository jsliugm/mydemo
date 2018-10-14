package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
	public static void main(String[] args) {
		/*String html = "aaa<col class='col1'>aaaaabcdef</col>";
		String format = "<col class='col1'>(a{1,3})([a-zA-Z]*)</col>";
		Pattern pattern = Pattern.compile(format);
		Matcher matcher = pattern.matcher(html);
		boolean b = matcher.find();*/
		/*System.out.println(b);
		System.out.println(matcher.group());
		System.out.println(matcher.start(1));
		//System.out.println(matcher.);
		System.out.println(matcher.group(1));*/
		
		String numStr = "www4";
		String numFormat = "^[\\d\\w]{3}4$";
		Pattern pattern = Pattern.compile(numFormat);
		Matcher matcher = pattern.matcher(numStr);
		boolean b = matcher.find();
		System.out.println(b);
		System.out.println(matcher.group());
		
	}
}
