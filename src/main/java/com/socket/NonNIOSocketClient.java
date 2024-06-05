package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NonNIOSocketClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int portNumber = 8888;
        try (Socket socket = new Socket(serverAddress, portNumber);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            // 发送消息给服务器
            String message = "Hello, NIO Server!";
            writer.println(message);
            System.out.println("");
            // 接收服务器响应
            String serverResponse = reader.readLine();
            System.out.println("Server response: " + serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
