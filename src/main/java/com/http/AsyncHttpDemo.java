package com.http;

import org.apache.http.client.config.RequestConfig;

/**
 * Created by jsliu on 2019/4/16.
 */
public class AsyncHttpDemo {
    public static void main(String[] args) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(50000)
                .setSocketTimeout(50000)
                .setConnectionRequestTimeout(1000)
                .build();
    }
}
