package ru.aizen.domain;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;

public class AbbyyClient {
    private HttpClient httpClient;

    private static final String HOST = "developers.lingvolive.com";
    private static final int PORT = 443;
    private static final String AUTHENTICATE = "/api/v1.1/authenticate";
    private static final String TRANSLATION = "/api/v1/Translation";
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTHORIZATION_BASIC = "Basic";
    private static final String AUTHORIZATION_BEARER = "Bearer";


    private static final HttpHost lingvolive= new HttpHost(HOST, PORT, "https");

    public AbbyyClient() {
        this.httpClient = HttpClients.createDefault();
    }

    public String getAuthorizeKey(String key) throws IOException {
        HttpPost post = new HttpPost(AUTHENTICATE);
        post.addHeader(AUTHORIZATION_HEADER, AUTHORIZATION_BASIC + " " + key);
        return EntityUtils.toString(httpClient.execute(lingvolive, post).getEntity());
    }

    public String getTranslationResponse(String word, int source, int target, String key) throws IOException {
        HttpGet get = new HttpGet(TRANSLATION +
                "?text=" + URLEncoder.encode(word, "UTF-8")
                + "&srcLang=" + source
                + "&dstLang=" + target);
        get.addHeader(AUTHORIZATION_HEADER, AUTHORIZATION_BEARER + " " + key);
        return EntityUtils.toString(httpClient.execute(lingvolive, get).getEntity());
    }
}
