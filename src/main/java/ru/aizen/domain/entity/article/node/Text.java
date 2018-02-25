package ru.aizen.domain.entity.article.node;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Text extends ArticleNode {
    @JsonProperty("IsItalic")
    private boolean isItalic;
    @JsonProperty("IsAccent")
    private boolean isAccent;

    public Text() {
        node = NodeType.TEXT;
    }

    public boolean isItalic() {
        return isItalic;
    }

    public void setItalic(boolean italic) {
        isItalic = italic;
    }

    public boolean isAccent() {
        return isAccent;
    }

    public void setAccent(boolean accent) {
        isAccent = accent;
    }

    @Override
    public String toString() {
        return "Text{" +
                "isItalic=" + isItalic +
                ", isAccent=" + isAccent +
                ", node=" + node +
                ", text='" + text + '\'' +
                ", isOptional=" + isOptional +
                '}';
    }
}
