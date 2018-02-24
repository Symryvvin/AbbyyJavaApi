package ru.aizen.domain;

import org.apache.http.client.HttpClient;

public final class AbbyyBuilder {
    private String apiKey;
    private HttpClient httpClient;
    private Dictionary dictionary;
    private Language sourceLang;
    private Language targetLang;


    public AbbyyBuilder(String apiKey) {
        this.apiKey = apiKey;
    }

    public static AbbyyBuilder create(String apiKey) {
        return new AbbyyBuilder(apiKey);
    }

    public AbbyyBuilder setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    public AbbyyBuilder setDictionary(Dictionary dictionary) {
        if (sourceLang != null || targetLang != null) {
            throw new RuntimeException("Can't set dictionary after set translate direction");
        }
        this.dictionary = dictionary;
        return this;
    }

    public AbbyyBuilder setTranslateDirection(Language sourceLang, Language targetLang) {
        if (dictionary != null) {
            throw new RuntimeException("Can't set translate direction after set dictionary");
        }
        boolean exist = false;
        for (Dictionary dictionary : Dictionary.values()) {
            if (dictionary.getSourceLang().equals(sourceLang) && dictionary.getTargetLang().equals(targetLang)) {
                exist = true;
            }
        }
        if (!exist) {
            throw new RuntimeException("Available dictionaries for specified direction are not found");
        }
        this.sourceLang = sourceLang;
        this.targetLang = targetLang;
        return this;
    }

    public Abbyy build() {
        if (dictionary != null)
            return new Abbyy(apiKey, httpClient,
                    dictionary);
        return new Abbyy(apiKey, httpClient, sourceLang, targetLang);
    }
}
