package ru.aizen.domain;


import java.io.IOException;
import java.net.URISyntaxException;

public class Abbyy {
    private AbbyyClient client;
    private Language source;
    private Language destination;

    public Abbyy(AbbyyClient client, Translation translation) {
        this.client = client;
        if (translation instanceof Dictionary) {
            Dictionary dictionary = (Dictionary) translation;
            this.source = dictionary.getSourceLang();
            this.destination = dictionary.getTargetLang();
        }
        if (translation instanceof TranslateDirection) {
            TranslateDirection direction = (TranslateDirection) translation;
            this.source = direction.getSource();
            this.destination = direction.getDestination();
        }
    }

    public String getTranslatePage(String word) throws IOException, URISyntaxException {
        //todo check code, use http utils, must return list of articles
        return client.getTranslationResponse(word, source.getCode(), destination.getCode());
    }

    public String getArticle() {
        //todo  dictionaries not found for specified direction
        //todo  specified dictionary is not found
        //todo  specified article is not found
        //todo must return article
        return null;
    }

    public Language getSource() {
        return source;
    }

    public Language getDestination() {
        return destination;
    }
}
