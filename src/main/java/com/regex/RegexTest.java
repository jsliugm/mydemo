package com.regex;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

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
		while(m.find())
		System.out.println(m.group());
	}
	@Test
	public void test2(){
		String input="abcdef";
		String strPattern="[a-zA-Z]*";
		Pattern p = Pattern.compile(strPattern);
		Matcher m = p.matcher(input);
		if(m.find()){System.out.println(m.group());}
	}

}
