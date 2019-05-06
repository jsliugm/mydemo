package com.java8;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jsliu on 2019/4/28.
 */
public class LambdaTest {
	/**
	 * 字符串拼接测试
	 */
	@Test
	public void test() {
		List<String> list = Lists.newArrayList("a", "b", "c");
		String ss = list.stream().map(item -> item.toString()).collect(Collectors.joining(" 且 "));
		System.out.println(ss);
	}
}
