package com.exception;

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

	public static void main(String[] args) {
		System.out.println(exTest1());
		System.out.println(exTest2());
	}
}
