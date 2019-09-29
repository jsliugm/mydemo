package com.clazz;

import java.util.ArrayList;
import java.util.List;

final public class Book {
	protected Book(){}
	private static List<String> names = new ArrayList<String>();

	
	public void addName(String name){
		names.add(name);
	}
	
	public static List<String> getNames() {
		return names;
	}

	public static void setNames(List<String> names) {
		Book.names = names;
	}
	
	public static void main(String[] args) {
		Book book1 = new Book();
		book1.addName("abc");
		Book book2 = new Book();
		book2.addName("cde");
		
		System.out.println(book2.getNames());
		
	}
}
