package com.java;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaDemo implements Serializable {
	private List aa;
	private Map aaa;
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

	@Test
	public void test(){
		StringBuffer a,b,c = new StringBuffer();

		List<Integer> list = IntStream.range(0,2).boxed().collect(Collectors.toList());

		System.out.println(list);
	}
	@Test
	public void test37(){
		Integer i = Integer.MAX_VALUE;
		System.out.println(i);
	}
}
