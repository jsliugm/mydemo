package com.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOInTest {
    public static void main(String[] args) throws Exception {
        File file = new File("d:/1.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel fileChannel = inputStream.getChannel();// 流变channel
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        fileChannel.read(byteBuffer);//从channel中读数据给buffer
        byteBuffer.flip();//翻转 从写变成读模式
        while (byteBuffer.hasRemaining()) {//buffer 中是否还有元素
            byte b = byteBuffer.get();
            System.out.print((char) b);
        }
        inputStream.close();
    }
}
