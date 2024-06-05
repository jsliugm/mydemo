package com.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
@Slf4j
public class NIOServer {

    public static void main(String[] args) {
        int portNumber = 8888;

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
             Selector selector = Selector.open()) {

            serverSocketChannel.bind(new InetSocketAddress(portNumber));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            //System.out.println("Server is listening on port " + portNumber);
            log.info("Server is listening on port " + portNumber);

            while (true) {
                selector.select();

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    if (key.isAcceptable()) {
                        // 新的客户端连接
                        acceptConnection(key, selector);
                    } else if (key.isReadable()) {
                        // 客户端发送消息
                        readMessage(key);
                    }

                    keyIterator.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void acceptConnection(SelectionKey key, Selector selector) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);

//        System.out.println("Accepted new connection: " + socketChannel.getRemoteAddress());
        log.info("Accepted new connection: " + socketChannel.getRemoteAddress());
    }

    private static void readMessage(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        log.info(socketChannel.toString());
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(buffer);

        if (bytesRead == -1) {
            // 客户端关闭连接
            //System.out.println("Connection closed: " + socketChannel.getRemoteAddress());
            log.info("Connection closed: " + socketChannel.getRemoteAddress());
            socketChannel.close();
        } else if (bytesRead > 0) {
            // 读取客户端发送的消息
            buffer.flip();
            byte[] data = new byte[buffer.remaining()];
            buffer.get(data);
            String message = new String(data);
            //System.out.println("Received message from " + socketChannel.getRemoteAddress() + ": " + message);
            log.info("Received message from " + socketChannel.getRemoteAddress() + ": " + message);
        }
    }
}
