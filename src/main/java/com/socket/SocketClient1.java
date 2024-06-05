package com.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient1 {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int portNumber = 8888;

        try (Socket socket = new Socket(serverAddress, portNumber);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            // 发送消息给服务器
            writer.println("Hello, Server!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
