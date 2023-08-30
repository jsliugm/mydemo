package com.exception;

import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionDemo {
	private static int exTest1() {

		try {
			return 1;
		} catch (Exception e) {
			// throw new Exception("aaaa");
		} finally {
			System.out.println("this is finally....");
			return 2;

		}
	}

	public static int exTest2() {
		int i = 0;
		try {
			return i;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			i++;
		}
		return i;
	}
   	public static void test(){
		int i =0;
		int j=1;
		i=j/i;
	}
	public static void main(String[] args) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		try {
			test();
		} catch (Exception e) {
			e.printStackTrace(printWriter);
		}
		System.out.println(stringWriter.toString());

	}
	@Test
	public void testNullP(){
		Object o = new Object();


		System.out.println(o.toString());

		o = null;

		try {
			System.out.println(o.toString());
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			if(e.getMessage()==null) {
				System.out.println("null ~~~~~");
			}
		}
	}
}
