package ru.aizen.domain.entity.article.node;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.annotation.Target;
import java.util.List;

public class Paragraph extends ArticleNode {
    @JsonProperty("Markup")
    private List<ArticleNode> markup;

    public Paragraph() {
        node = NodeType.PARAGRAPH;
    }

    public List<ArticleNode> getMarkup() {
        return markup;
    }

    public void setMarkup(List<ArticleNode> markup) {
        this.markup = markup;
    }

    /**
     * Get full paragraph string from markups
     * @return full paragraph
     */
    public String getPlainText() {
        StringBuilder result = new StringBuilder();
        for (ArticleNode node : markup) {
            if (node instanceof Transcription) {
                result.append(((Transcription) node).getTranscription());
            }
            if (node instanceof Abbrev) {
                result.append(node.getText());
            }
            if (node instanceof Sound) {
                result.append(((Sound) node).getFileName());
            }
            if (node instanceof Text) {
                Text text = (Text) node;
                if (text.isAccent()) {
                    result.append(text.getText()).append("´");
                } else {
                    result.append(text.getText());
                }
            }
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "markup=" + markup +
                ", node=" + node +
                ", text='" + text + '\'' +
                ", isOptional=" + isOptional +
                '}';
    }
}
