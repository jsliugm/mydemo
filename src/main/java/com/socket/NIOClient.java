package com.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {

    public static void main(String[] args) {
       // String serverAddress = "localhost";
        String serverAddress = "192.168.126.131";
        int portNumber = 8888;

        try (SocketChannel socketChannel = SocketChannel.open()) {
            socketChannel.connect(new InetSocketAddress(serverAddress, portNumber));

            // 发送消息给服务器
            String message = "Hello, Server!\r\n";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            socketChannel.write(buffer);

            // 接收服务器响应
            ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
            int bytesRead = socketChannel.read(responseBuffer);
            if (bytesRead > 0) {
                responseBuffer.flip();
                byte[] responseData = new byte[responseBuffer.remaining()];
                responseBuffer.get(responseData);
                String serverResponse = new String(responseData);
                System.out.println("Server response: " + serverResponse);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
