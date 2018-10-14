package com.java;

public class JavaDemo {
	public static void main(String[] args) {
		int i = 0;
		// System.out.println("aaaa");
		top1: while (i < 4) {
			System.out.println(i);
			i++;
			continue top1;
		}
		i=0;
		System.out.println(i++);
		System.out.println(++i);
	}
}
