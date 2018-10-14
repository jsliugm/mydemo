package com;

public class FinalDemo {
	public int i;

	public static int test(int a) {
		return a++;
	}

	public void test(final FinalDemo fi) {
		fi.i++;
	}

	public static void main(String[] args) {
		int i = 1;
		FinalDemo.test(i);
	}
}
