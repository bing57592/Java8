package com.ysu.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;

/**
 * created by bing57592
 * 2018-10-28 11:13
 */
public class HttpClientUtils {

    private static CloseableHttpClient client = null;

    static {
        client = HttpClients.createDefault();
    }

    /**
     * 发送get请求
     *
     * @param url
     */
    public static String executeGetReq(String url) {
        String target = url;

        try {
            // 创建Get请求, 并发送.
            CloseableHttpResponse res = client.execute(new HttpGet(target));
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                ContentType contentType = ContentType.getOrDefault(entity);
                Charset charset = contentType.getCharset();
                byte[] content = EntityUtils.toByteArray(entity);
                return new String(content, charset);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
