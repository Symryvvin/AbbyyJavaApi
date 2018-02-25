package ru.aizen.domain.entity.article.node;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListItem extends ArticleNode {
    @JsonProperty("Markup")
    private List<ArticleNode> markup;

    public ListItem() {
        node = NodeType.LISTITEM;
    }

    public List<ArticleNode> getMarkup() {
        return markup;
    }

    public void setMarkup(List<ArticleNode> markup) {
        this.markup = markup;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "markup=" + markup +
                ", node=" + node +
                ", text='" + text + '\'' +
                ", isOptional=" + isOptional +
                '}';
    }
}
