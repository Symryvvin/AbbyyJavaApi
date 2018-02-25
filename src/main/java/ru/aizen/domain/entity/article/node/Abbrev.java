package ru.aizen.domain.entity.article.node;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Abbrev extends ArticleNode {
    @JsonProperty("FullText")
    private String fullText;

    public Abbrev() {
        node = NodeType.ABBREV;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    @Override
    public String toString() {
        return "Abbrev{" +
                "fullText='" + fullText + '\'' +
                ", node=" + node +
                ", text='" + text + '\'' +
                ", isOptional=" + isOptional +
                '}';
    }
}
