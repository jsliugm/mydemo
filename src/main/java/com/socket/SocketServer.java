package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jsliu
 */
public class SocketServer {

    public static void main(String[] args) {
        int portNumber = 8888;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server is waiting for client on port " + portNumber);

            // 等待客户端连接
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            // 读取客户端发送的消息
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String clientMessage = reader.readLine();
            System.out.println("Client message: " + clientMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
