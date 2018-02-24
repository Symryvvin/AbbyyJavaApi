package ru.aizen.domain;

import org.apache.http.client.HttpClient;

public final class AbbyyBuilder {
    private HttpClient httpClient;
    private Dictionary dictionary;
    private Language sourceLang;
    private Language targetLang;


    private AbbyyBuilder() {
    }

    public static AbbyyBuilder create() {
        return new AbbyyBuilder();
    }

    public AbbyyBuilder setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    public AbbyyBuilder setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
        return this;
    }

    public AbbyyBuilder setTranslateDirection(Language sourceLang, Language targetLang) {
        boolean exist = false;
        for (Dictionary dictionary : Dictionary.values()) {
            if (dictionary.getSourceLang().equals(sourceLang) && dictionary.getTargetLang().equals(targetLang)) {
                exist = true;
            }
        }
        if (!exist) {
            throw new RuntimeException("There is no this direction in available dictionaries");
        }
        this.sourceLang = sourceLang;
        this.targetLang = targetLang;
        return this;
    }

    public Abbyy build() {
        return new Abbyy(httpClient,
                dictionary);
    }
}
