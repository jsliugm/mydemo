package com.io.base64;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64ToBinary {
    /**
     * 将 Base64 编码的文本文件转换为二进制文件
     *
     * @param base64FilePath Base64 编码的文本文件路径
     * @param binaryFilePath 二进制文件路径
     * @throws IOException
     */
    public static void base64ToBinary(String base64FilePath, String binaryFilePath) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(base64FilePath){
            @Override
            public void close() throws IOException {
                System.out.println("匿名对象的资源关闭了哟");
                super.close();
            }
        }, StandardCharsets.UTF_8);
             OutputStream os = new FileOutputStream(binaryFilePath)) {
            Base64.Decoder decoder = Base64.getDecoder();
            // 4KB字符缓冲区
            char[] buffer = new char[4096];
            int charsRead;

            while ((charsRead = reader.read(buffer)) != -1) {
                // 直接流式解码
                byte[] decoded = decoder.decode(
                        CharBuffer.wrap(buffer, 0, charsRead).toString()
                );
                os.write(decoded);
            }
        }
    }

    public static void main(String[] args) {
//
//        // 定义输入文件路径
//        String inputFile = "restored_binary_file.jpg";
//        // 定义输出文件路径
//        String outputFile = "output_base64.txt";
        try {
            base64ToBinary("output_base64.txt", "restored_binary_file22.jpg");
            System.out.println("Base64 编码的文本文件已成功转换为二进制文件！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}  