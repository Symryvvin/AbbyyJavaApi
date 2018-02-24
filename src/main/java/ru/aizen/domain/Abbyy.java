package ru.aizen.domain;


import org.apache.http.client.HttpClient;

public class Abbyy {
    private HttpClient httpClient;
    private Language sourceLang;
    private Language targetLang;
    private Dictionary dictionary;

    public Abbyy(HttpClient httpClient, Dictionary dictionary) {
        this.httpClient = httpClient;
        this.dictionary = dictionary;
    }

    public Abbyy(HttpClient httpClient, Language sourceLang, Language targetLang) {
        this.httpClient = httpClient;
        this.sourceLang = sourceLang;
        this.targetLang = targetLang;
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
