package com.charset;

public class CharsetDemo {
	static void printBytes(byte[] bytes){
		for(byte b : bytes){
			System.out.print(Integer.toHexString(b)+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) throws Exception{
		String str1 = "中";
		byte[] defaultByte = str1.getBytes("utf-8");
		byte[] specialByte = str1.getBytes();
		//String str2 = new String(defaultByte);
		//System.out.println(str2);
		printBytes(defaultByte);
		printBytes(specialByte);

	}
}
