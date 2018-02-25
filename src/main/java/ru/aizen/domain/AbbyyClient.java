package ru.aizen.domain;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AbbyyClient {
    private HttpClient httpClient;

    private static final String HOST = "developers.lingvolive.com";
    private static final int PORT = 443;
    private static final String AUTHENTICATE = "/api/v1.1/authenticate";
    private static final String TRANSLATION = "/api/v1/Translation";
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTHORIZATION_BASIC = "Basic ";
    private static final String AUTHORIZATION_BEARER = "Bearer ";

    private String authorizationKey;


    private static final HttpHost lingvolive= new HttpHost(HOST, PORT, "https");

    public AbbyyClient(String key) throws IOException {
        this.httpClient = HttpClients.createDefault();
        authorize(key);
    }

    private void authorize(String key) throws IOException {
        HttpPost post = new HttpPost(AUTHENTICATE);
        post.addHeader(AUTHORIZATION_HEADER, AUTHORIZATION_BASIC + key);
        authorizationKey = EntityUtils.toString(httpClient.execute(lingvolive, post).getEntity());
    }

    public String getTranslationResponse(String text, Integer source, Integer destination) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(TRANSLATION)
                .addParameter("text", text)
                .addParameter("srcLang", source.toString())
                .addParameter("dstLang", destination.toString())
                .build();
        HttpGet get = new HttpGet(uri);
        get.addHeader(AUTHORIZATION_HEADER, AUTHORIZATION_BEARER + authorizationKey);
        return EntityUtils.toString(httpClient.execute(lingvolive, get).getEntity());
    }
}
