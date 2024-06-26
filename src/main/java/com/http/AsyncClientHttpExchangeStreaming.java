///*
// * ====================================================================
// * Licensed to the Apache Software Foundation (ASF) under one
// * or more contributor license agreements.  See the NOTICE file
// * distributed with this work for additional information
// * regarding copyright ownership.  The ASF licenses this file
// * to you under the Apache License, Version 2.0 (the
// * "License"); you may not use this file except in compliance
// * with the License.  You may obtain a copy of the License at
// *
// *   http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing,
// * software distributed under the License is distributed on an
// * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// * KIND, either express or implied.  See the License for the
// * specific language governing permissions and limitations
// * under the License.
// * ====================================================================
// *
// * This software consists of voluntary contributions made by many
// * individuals on behalf of the Apache Software Foundation.  For more
// * information on the Apache Software Foundation, please see
// * <http://www.apache.org/>.
// *
// */
//package com.http;
//
//import org.apache.hc.client5.http.async.methods.AbstractCharResponseConsumer;
//import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
//import org.apache.hc.client5.http.classic.methods.HttpPost;
//import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
//import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
//import org.apache.hc.core5.http.ContentType;
//import org.apache.hc.core5.http.HttpException;
//import org.apache.hc.core5.http.HttpHost;
//import org.apache.hc.core5.http.HttpResponse;
//import org.apache.hc.core5.http.io.entity.StringEntity;
//import org.apache.hc.core5.http.message.BasicHttpRequest;
//import org.apache.hc.core5.http.message.StatusLine;
//import org.apache.hc.core5.http.nio.support.BasicRequestProducer;
//import org.apache.hc.core5.http.support.BasicRequestBuilder;
//import org.apache.hc.core5.io.CloseMode;
//import org.apache.hc.core5.reactor.IOReactorConfig;
//import org.apache.hc.core5.util.Timeout;
//
//import java.io.IOException;
//import java.nio.CharBuffer;
//import java.util.Collection;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.Future;
//
///**
// * Example of asynchronous HTTP/1.1 request execution with response streaming.
// */
//public class AsyncClientHttpExchangeStreaming {
//    private static CloseableHttpAsyncClient createClient() {
//        final IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
//                .setSoTimeout(Timeout.ofSeconds(5))
//                .build();
//
//        final CloseableHttpAsyncClient client = HttpAsyncClients.custom()
//                .setIOReactorConfig(ioReactorConfig)
//                .build();
//
//        client.start();
//        return client;
//    }
//
//    public Map<String, String> post(Collection<String> urls, String requestBody) {
//
//        Map<String, String> map = new ConcurrentHashMap<>();
//
//        CloseableHttpAsyncClient client = createClient();
//        for (String url : urls) {
//            HttpPost httpPost = new HttpPost(url);
//            httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
//            StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
//            httpPost.setEntity(entity);
//            client.execute(new SimpleHttpRequest())
//        }
//
//
//        return null;
//    }
//
//    public static void main(final String[] args) throws Exception {
//
//        final IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
//                .setSoTimeout(Timeout.ofSeconds(5))
//                .build();
//
//        final CloseableHttpAsyncClient client = HttpAsyncClients.custom()
//                .setIOReactorConfig(ioReactorConfig)
//                .build();
//
//        client.start();
//
//        final HttpHost target = new HttpHost("httpbin.org");
//        final String[] requestUris = new String[]{"/", "/ip", "/user-agent", "/headers"};
//
//        for (final String requestUri : requestUris) {
//
//            final BasicHttpRequest request = BasicRequestBuilder.get()
//                    .setHttpHost(target)
//                    .setPath(requestUri)
//                    .build();
//
//            System.out.println("Executing request " + request);
//
//            final Future<Void> future = client.execute(
//                    new BasicRequestProducer(request, null),
//                    new AbstractCharResponseConsumer<Void>() {
//
//                        @Override
//                        protected void start(
//                                final HttpResponse response,
//                                final ContentType contentType) throws HttpException, IOException {
//                            System.out.println(request + "->" + new StatusLine(response));
//                        }
//
//                        @Override
//                        protected int capacityIncrement() {
//                            return Integer.MAX_VALUE;
//                        }
//
//                        @Override
//                        protected void data(final CharBuffer data, final boolean endOfStream) throws IOException {
//                            while (data.hasRemaining()) {
//                                System.out.print(data.get());
//                            }
//                            if (endOfStream) {
//                                System.out.println();
//                            }
//                        }
//
//                        @Override
//                        protected Void buildResult() throws IOException {
//                            return null;
//                        }
//
//                        @Override
//                        public void failed(final Exception cause) {
//                            System.out.println(request + "->" + cause);
//                        }
//
//                        @Override
//                        public void releaseResources() {
//                        }
//
//                    }, null);
//            future.get();
//        }
//
//        System.out.println("Shutting down");
//        client.close(CloseMode.GRACEFUL);
//    }
//
//}