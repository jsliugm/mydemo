package com.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 完全排序
 * 
 * @author c_liuguangming003
 * 
 */
public class AnagramApp {
	static int size;
	static int count;
	static char[] arryChar = new char[100];

	public static void doAnagram(int newSize) {
		if (newSize == 1)
			return;
		for (int j = 0; j < newSize; j++) {
			doAnagram(newSize - 1);
			if (newSize == 2) {
				displayWord();
			}
			rotate(newSize);
		}
	}

	/**
	 * 当前位置的字母移动到最后，其他的向前移动
	 * @param newSize
	 */
	public static void rotate(int newSize) {
		int j;
		int position = size - newSize;
		char temp = arryChar[position];
		for (j = position + 1; j < size; j++) {
			arryChar[j - 1] = arryChar[j];
		}
		arryChar[j - 1] = temp;
	}

	public static void displayWord() {
		if (count < 99) {
			System.out.print(" ");
		}
		if (count < 9) {
			System.out.print(" ");
		}
		System.out.print(++count + " ");
		for (int j = 0; j < size; j++)
			System.out.print(arryChar[j]);
		// System.out.print(arryChar);
		System.out.print("  ");
		System.out.flush();
		if (count % 6 == 0)
			System.out.println("");
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String result = br.readLine();
		return result;
	}

	public static void main(String[] args) throws IOException {
		System.out.print("Enter a word:");
		String input = getString();
		size = input.length();
		count = 0;
		for (int j = 0; j < size; j++)
			arryChar[j] = input.charAt(j);
		doAnagram(size);
	}
}
