package com.map;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
	public static void main(String[] args) throws IllegalArgumentException,
			IllegalAccessException {
		Map<Object, Object> map = new HashMap<Object, Object>(65);

		Class clazz = HashMap.class;

		for (Field f : clazz.getDeclaredFields()) {
			if (f.getName().equals("table")) {
				f.setAccessible(true);
				java.util.Map.Entry<Object, Object> entry[] = (java.util.Map.Entry<Object, Object>[]) (f
						.get(map));
				System.out.println(entry.length);
			}
		}
	}
}
