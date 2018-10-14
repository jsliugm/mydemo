package com;

public class StaticClassDemo {
	public static void main(String[] args) {
		new StaticClassDemo(){
			public void print(){
				System.out.println("aaaa");
			}
		}.print();;
	}
}
