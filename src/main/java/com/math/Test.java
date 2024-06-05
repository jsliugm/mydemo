package com.math;

public class Test {
	// 按位与运算符（&）
	// 参加运算的两个数据，按二进制位进行“与”运算。
	// 运算规则：0&0=0; 0&1=0; 1&0=0; 1&1=1;
	//
	// 按位或运算符（|）
	// 参加运算的两个对象，按二进制位进行“或”运算。
	// 运算规则：0|0=0； 0|1=1； 1|0=1； 1|1=1；
	//
	// 异或运算符（^）
	// 参加运算的两个数据，按二进制位进行“异或”运算。
	// 运算规则：0^0=0； 0^1=1； 1^0=1； 1^1=0；

	public static void main(String[] args) {
		// N1蓝牙开门；N2一次性密码；N3自定义密码；N4随机密码；N5绑定NFC；N6绑定指纹；
		System.out.println("假设有权限N1~N6：");
		int[] N = new int[7];
		for (int i = 1; i < N.length; i++) {
			N[i] = (int) Math.pow(2, i - 1);
			System.out.print("N" + i + "=" + N[i] + "  ");
		}
		// ====================================================
		int authority = buildAuth(N[1], N[2], N[3], N[4], N[5]);// build
		System.out.println("\n\n构造N1~N5权限值:" + authority);
		print(N, authority);

		authority = delAuth(authority, N[3]); // del
		System.out.println("\n删除N3后，权限值:" + authority);
		print(N, authority);

		authority = addAuth(authority, N[6]);
		System.out.println("\n添加N6后，权限值:" + authority);
		print(N, authority);
	}

	private static void print(int[] N, int authority) {
		for (int i = 1; i < N.length; i++)
			System.out.println("  检查权限N" + i + ":" + checkAuth(authority, N[i])); // check
	}

	/**
	 * 生成权重值
	 */
	public static int buildAuth(int... values) {
		int authority = 0;// 初始化权限值为0
		for (int i = 0; i < values.length; i++)
			authority=addAuth(authority, values[i]);
		return authority;
	}

	/**
	 * 校验当前权限value
	 */
	public static boolean checkAuth(int authority, int value) {
		return (authority & value) == value;
	}

	/**
	 * 删除权限
	 */
	public static int delAuth(int authority, int value) {
		return authority & (~value);
	}

	/**
	 * 新增权限
	 */
	public static int addAuth(int authority, int value) {
		return authority |= value;
	}
}