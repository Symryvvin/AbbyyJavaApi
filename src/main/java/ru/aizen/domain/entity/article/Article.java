package ru.aizen.domain.entity.article;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.aizen.domain.entity.article.node.ArticleNode;

import java.util.List;


/**
 * ArticleModel class represent full object model of request to word/phrase translation
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("TitleMarkup")
    private List<ArticleNode> titleMarkup;
    @JsonProperty("Dictionary")
    private String dictionary;
    @JsonProperty("ArticleId")
    private String articleId;
    @JsonProperty("Body")
    private List<ArticleNode> body;

    public Article() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ArticleNode> getTitleMarkup() {
        return titleMarkup;
    }

    public void setTitleMarkup(List<ArticleNode> titleMarkup) {
        this.titleMarkup = titleMarkup;
    }

    public String getDictionary() {
        return dictionary;
    }

    public void setDictionary(String dictionary) {
        this.dictionary = dictionary;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public List<ArticleNode> getBody() {
        return body;
    }

    public void setBody(List<ArticleNode> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ArticleModel{" +
                "title='" + title + '\'' +
                ", titleMarkup=" + titleMarkup +
                ", dictionary='" + dictionary + '\'' +
                ", articleId='" + articleId + '\'' +
                ", body=" + body +
                '}';
    }
}
