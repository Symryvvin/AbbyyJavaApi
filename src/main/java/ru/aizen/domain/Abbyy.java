package ru.aizen.domain;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.aizen.domain.entity.article.Article;
import ru.aizen.domain.translate.Language;
import ru.aizen.domain.translate.Translation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Abbyy {
    private AbbyyClient client;
    private Language source;
    private Language destination;

    private ObjectMapper mapper;

    public Abbyy(AbbyyClient client, Translation translation) {
        this.client = client;
        this.source = translation.getSource();
        this.destination = translation.getDestination();
        this.mapper = new ObjectMapper();
    }

    public List<Article> getTranslatePage(String word) throws IOException, URISyntaxException {
        return mapper.readValue(client.getTranslation(word, source.getCode(), destination.getCode()),
                new TypeReference<List<Article>>() {
                });
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
