package ru.aizen.domain;


import java.io.IOException;

public class Abbyy {
    private AbbyyClient client;
    private Language sourceLang;
    private Language targetLang;
    private Dictionary dictionary;

    public Abbyy(AbbyyClient client, Dictionary dictionary) {
        this.client = client;
        this.dictionary = dictionary;
    }

    public Abbyy(AbbyyClient client, Language sourceLang, Language targetLang) {
        this.client = client;
        this.sourceLang = sourceLang;
        this.targetLang = targetLang;
    }

    public String getTranslatePage(String word) throws IOException {
        //todo check code, use http utils, must return list of articles
        Integer source = dictionary != null ? dictionary.getSourceLang().getCode() : sourceLang.getCode();
        Integer target = dictionary != null ? dictionary.getTargetLang().getCode() : targetLang.getCode();
        return client.getTranslationResponse(word, source, target);
    }

    public String getArticle(){
        //todo  dictionaries not found for specified direction
        //todo  specified dictionary is not found
        //todo  specified article is not found
        //todo must return article
        return null;
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
