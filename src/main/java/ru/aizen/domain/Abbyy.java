package ru.aizen.domain;


import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;

public class Abbyy {
    private HttpClient httpClient;
    private Language sourceLang;
    private Language targetLang;
    private Dictionary dictionary;
    private String apiKey;
    private String authKey;

    private static final String AUTHENTICATE = "/api/v1.1/authenticate";
    private static final String TRANSLATION = "/api/v1/Translation";

    private static final HttpHost lingvolive = new HttpHost("developers.lingvolive.com", 443, "https");

    public Abbyy(String apiKey, HttpClient httpClient, Dictionary dictionary) {
        this.apiKey = apiKey;
        this.httpClient = httpClient;
        this.dictionary = dictionary;
    }

    public Abbyy(String apiKey, HttpClient httpClient, Language sourceLang, Language targetLang) {
        this.apiKey = apiKey;
        this.httpClient = httpClient;
        this.sourceLang = sourceLang;
        this.targetLang = targetLang;
    }

    public void authorize() throws IOException {
        HttpPost post = new HttpPost(AUTHENTICATE);
        post.addHeader("Authorization", "Basic " + apiKey);
        authKey = EntityUtils.toString(httpClient.execute(lingvolive, post).getEntity());
    }

    public String getTranslatePage(String word) throws IOException {
        //todo check code, use http utils, must return list of articles
        Integer source = dictionary != null ? dictionary.getSourceLang().getCode() : sourceLang.getCode();
        Integer target = dictionary != null ? dictionary.getTargetLang().getCode() : targetLang.getCode();
        HttpGet get = new HttpGet(TRANSLATION + "" +
                "?text=" + URLEncoder.encode(word, "UTF-8")
                + "&srcLang=" + source
                + "&dstLang=" + target);
        get.addHeader("Authorization", "Bearer " + authKey);
        return EntityUtils.toString(httpClient.execute(lingvolive, get).getEntity());
    }

    public String getArticle(){
        //todo  dictionaries not found for specified direction
        //todo  specified dictionary is not found
        //todo  specified article is not found
        //todo must return article
        return null;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public Language getSourceLang() {
        if (dictionary != null)
            return dictionary.getSourceLang();
        else
            return sourceLang;
    }

    public Language getTargetLang() {
        if (dictionary != null)
            return dictionary.getTargetLang();
        else
            return targetLang;
    }
}
