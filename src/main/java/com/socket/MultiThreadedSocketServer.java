package com.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
@Slf4j
public class MultiThreadedSocketServer {

    public static void main(String[] args) {
        int portNumber = 8888;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            //System.out.println("Server is waiting for client on port " + portNumber);
            log.info("Server is waiting for client on port " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                //System.out.println("Client connected: " + clientSocket);
                log.info("Client connected: " + clientSocket);

                // 创建新的线程处理客户端请求
                Thread clientHandlerThread = new Thread(new ClientHandler(clientSocket));
                clientHandlerThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    //System.out.println("Received message from " + clientSocket + ": " + clientMessage);
                    log.info("Received message from " + clientSocket + ": " + clientMessage);

                    // 响应客户端
                    writer.println("Server received your message: " + clientMessage);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                    //System.out.println("Connection closed: " + clientSocket);
                    log.info("Connection closed: " + clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
