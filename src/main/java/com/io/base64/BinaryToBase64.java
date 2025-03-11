package com.io.base64;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BinaryToBase64 {
    /**
     * 将二进制文件转换为 Base64 编码的文本文件
     *
     * @param binaryFilePath 二进制文件路径
     * @param base64FilePath Base64 编码的文本文件路径
     * @throws IOException
     */
    public static void binaryToBase64(String binaryFilePath, String base64FilePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(binaryFilePath);
             OutputStreamWriter writer = new OutputStreamWriter(
                     new FileOutputStream(base64FilePath), StandardCharsets.UTF_8)) {

            Base64.Encoder encoder = Base64.getEncoder();
            // 3KB 缓冲区（3的倍数优化编码效率）
            byte[] buffer = new byte[3*1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                // 分块编码写入
                String encodedChunk = encoder.encodeToString(
                        java.util.Arrays.copyOfRange(buffer, 0, bytesRead)
                );
                writer.write(encodedChunk);
            }
        }
    }

    public static void main(String[] args) {
        try {
            binaryToBase64("restored_binary_file.jpg", "output_base64.txt");
            System.out.println("二进制文件已成功转换为 Base64 编码的文本文件！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}  