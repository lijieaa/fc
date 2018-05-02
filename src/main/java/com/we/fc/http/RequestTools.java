package com.we.fc.http;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.*;

/**
 * @author zdc
 * @since 2018-04-13 22:18
 */

public class RequestTools {

    public static String processHttpRequest(String url, String requestMethod, Map<String, String> paramsMap) {
        if(paramsMap == null) paramsMap = new HashMap<>();
        List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
        if ("post".equalsIgnoreCase(requestMethod)) {
            HttpPost httppost = new HttpPost(url);
            httppost.setHeader("Content-Type", "application/json");
            for (Iterator<String> it = paramsMap.keySet().iterator(); it.hasNext(); ) {
                String key = it.next();
                String value = paramsMap.get(key);
                formparams.add(new BasicNameValuePair(key, value));
            }
            return doRequest(httppost, null, formparams);
        } else if ("get".equalsIgnoreCase(requestMethod)) {
            HttpGet httppost = new HttpGet(url);
            for (Iterator<String> it = paramsMap.keySet().iterator(); it.hasNext(); ) {
                String key = it.next();
                String value = paramsMap.get(key);
                formparams.add(new BasicNameValuePair(key, value));
            }
            return doRequest(null, httppost, formparams);
        }
        return "";
    }

    public static String processUpload(String url, File file) throws IOException {

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000000).build();
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "multipart/form-data");
        httpPost.setConfig(requestConfig);
        multipartEntityBuilder.addBinaryBody("media",file);
        HttpEntity httpEntity = multipartEntityBuilder.build();
        httpPost.setEntity(httpEntity);
        CloseableHttpResponse response = HttpClientPool.getHttpClient().execute(httpPost);
        String str = null;
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instreams = entity.getContent();
            str = convertStreamToString(instreams);
            httpPost.abort();
        }
        return str;
    }

    private static String doRequest(HttpPost httpPost, HttpGet httpGet, List<BasicNameValuePair> formparams) {

        try {
            CloseableHttpResponse response = null;
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams);
            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig
                    .custom()
                    .setSocketTimeout(25000)
                    .setConnectTimeout(3000)
                    .build();
            if (null != httpPost) {
                uefEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                httpPost.setEntity(uefEntity);
                httpPost.setConfig(requestConfig);
                response = HttpClientPool.getHttpClient().execute(httpPost);
            } else {
                httpGet.setConfig(requestConfig);
                response = HttpClientPool.getHttpClient().execute(httpGet);
            }
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity, "UTF-8");
            if (null == str || "".equals(str)) {
                return "";
            } else {
                return str;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        return "";
    }
    public static String processPostJson(String postUrl, String json) throws ClientProtocolException, Exception {
        // HttpClient httpclient = new DefaultHttpClient();
        HttpPost post = new HttpPost(postUrl);
        post.setHeader("Content-Type", "application/json");
        String str = null;
        StringEntity s = new StringEntity(json, "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(25000).setConnectTimeout(3000).build();

        post.setEntity(s);
        post.setConfig(requestConfig);

        CloseableHttpResponse response = HttpClientPool.getHttpClient().execute(post);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instreams = entity.getContent();
            str = convertStreamToString(instreams);
            post.abort();
        }
        // System.out.println(str);
        return str;
    }

    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
