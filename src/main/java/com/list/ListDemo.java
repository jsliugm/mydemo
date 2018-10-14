package com.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<10;i++) list.add("tom"+i);
		System.out.println(list);
		//
		list.add(4, "tom88");
		System.out.println(list);
		list.remove("tom88");
		System.out.println(list);
		for(String str:list){
			list.remove(str);
			System.out.println(list);
		}
	}

}
