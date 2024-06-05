package com.http;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class AsyncHttpClient {

    private final static CloseableHttpAsyncClient client;

    static {
        client = createClient();
        client.start();
    }

    public static Map<String, String> post2(Collection<String> urlList, String requestBody) {
        if (CollectionUtils.isEmpty(urlList)) {
            return Collections.emptyMap();
        }
        Map<String, String> resultMap = new ConcurrentHashMap<>();
        try {
            //final CountDownLatch latch = new CountDownLatch(urlList.size());
            for (String url : urlList) {
                HttpPost httpPost = new HttpPost(url);
                httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
                StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                httpPost.setEntity(entity);
                client.execute(httpPost, new FutureCallback<HttpResponse>() {
                    @Override
                    public void completed(HttpResponse result) {
                        log.info("completed");
                        try {
                            String response = getResponse(result);
                            resultMap.put(url, response);
                        } catch (Exception e) {
                            log.error("", e);
                        }
                        //latch.countDown();
                    }

                    @Override
                    public void failed(Exception ex) {
                        log.error("failed", ex);
                        //latch.countDown();
                    }

                    @Override
                    public void cancelled() {
                        log.info("cancelled");
                        //latch.countDown();
                    }
                });
            }
            //latch.await();
        } catch (Exception e) {
            log.error("url:{} requestBody: {}", urlList, requestBody, e);
        }
        return resultMap;
    }


    private static CloseableHttpAsyncClient createClient() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setSocketTimeout(1000)
                .setConnectionRequestTimeout(500)
                .build();
        CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.custom().setDefaultRequestConfig(requestConfig).build();
        return httpAsyncClient;
    }

    public static Map<String, String> post(Collection<String> urlList, String requestBody) {
        if (CollectionUtils.isEmpty(urlList)) {
            return Collections.emptyMap();
        }
        Map<String, String> resultMap = new ConcurrentHashMap<>();
        try (CloseableHttpAsyncClient client = createClient()) {
            client.start();
            final CountDownLatch latch = new CountDownLatch(urlList.size());
            for (String url : urlList) {
                HttpPost httpPost = new HttpPost(url);
                httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
                StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                httpPost.setEntity(entity);
                client.execute(httpPost, new FutureCallback<HttpResponse>() {
                    @Override
                    public void completed(HttpResponse result) {
                        log.info("completed");
                        try {
                            String response = getResponse(result);
                            resultMap.put(url, response);
                        } catch (Exception e) {
                            log.error("", e);
                        }
                        latch.countDown();
                    }

                    @Override
                    public void failed(Exception ex) {
                        log.error("failed", ex);
                        latch.countDown();
                    }

                    @Override
                    public void cancelled() {
                        log.info("cancelled");
                        latch.countDown();
                    }
                });
            }
            latch.await();
        } catch (Exception e) {
            log.error("url:{} requestBody: {}", urlList, requestBody, e);
        }
        return resultMap;
    }

    private static String getResponse(HttpResponse result) throws Exception {
        if (result == null || result.getEntity() == null) {
            return null;
        }
        return EntityUtils.toString(result.getEntity(), Consts.UTF_8);
    }

    public static Map<String, String> post3(Collection<String> urlList, String requestBody) {
        if (CollectionUtils.isEmpty(urlList)) {
            return Collections.emptyMap();
        }
        Map<String, String> resultMap = new ConcurrentHashMap<>();
        try {
            final CountDownLatch latch = new CountDownLatch(urlList.size());
            for (String url : urlList) {
                HttpPost httpPost = new HttpPost(url);
                httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
                StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                httpPost.setEntity(entity);
                client.execute(httpPost, new FutureCallback<HttpResponse>() {
                    @Override
                    public void completed(HttpResponse result) {
                        log.info("completed");
                        try {
                            String response = getResponse(result);
                            resultMap.put(url, response);
                        } catch (Exception e) {
                            log.error("", e);
                        }
                        latch.countDown();
                    }

                    @Override
                    public void failed(Exception ex) {
                        log.error("failed", ex);
                        latch.countDown();
                    }

                    @Override
                    public void cancelled() {
                        log.info("cancelled");
                        latch.countDown();
                    }
                });
            }
            latch.await();
        } catch (Exception e) {
            log.error("url:{} requestBody: {}", urlList, requestBody, e);
        }
        return resultMap;
    }

    public static void main(String[] args) throws IOException {
        List<String> urlList = Lists.newArrayList("http://127.0.0.1:31001/sbd/http/test2");
        for (int i = 0; i < 100000; i++) {
            System.out.println(post(urlList, ""));
        }
        client.close();
    }
}
