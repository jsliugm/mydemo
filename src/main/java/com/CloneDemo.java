package com;

import java.util.ArrayList;

public class CloneDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		ArrayList<Object> list = new ArrayList<Object>();
		//Clone1 clone = new Clone1();
		Long l = System.currentTimeMillis();
		int i = 0;
		while (i < 10000000) {
			// new Clone1();
			list.add(new Clone1());
			// list.add(clone.clone());
			i++;
		}
		l = System.currentTimeMillis() - l;
		System.out.println(l);

	}
}

class Clone1 implements Cloneable {
	private int i = 0;
	private Clone1 clone;

	public Clone1 getClone() {
		return clone;
	}

	public void setClone(Clone1 clone) {
		this.clone = clone;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	protected Clone1 clone() throws CloneNotSupportedException {
		return (Clone1) super.clone();
	}
}
