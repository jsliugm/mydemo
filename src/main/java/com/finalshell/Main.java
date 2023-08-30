package com.finalshell;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("FinalShell-Keygen v1.0 - Developed by UltraPanda\n* Only for educational purpose *\n请输入离线激活所提供的机器码: ");
        String hardwareId = scanner.nextLine();
        System.out.printf("高级版激活码: %s\n专业版激活码: %s%n", transform('\uef79' + hardwareId + 8552), transform(2356 + hardwareId + 13593));
    }

    public static String transform(String str) throws NoSuchAlgorithmException {
        return hashMD5(str).substring(8, 24);
    }

    public static String hashMD5(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hashed = digest.digest(str.getBytes());
        StringBuilder sb = new StringBuilder();
        byte[] var4 = hashed;
        int var5 = hashed.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            byte b = var4[var6];
            int len = b & 255;
            if (len < 16) {
                sb.append("0");
            }

            sb.append(Integer.toHexString(len));
        }

        return sb.toString();
    }
}
