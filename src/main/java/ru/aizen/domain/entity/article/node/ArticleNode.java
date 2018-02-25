package ru.aizen.domain.entity.article.node;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "Node")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Comment.class, name = "Comment"),
        @JsonSubTypes.Type(value = Paragraph.class, name = "Paragraph"),
        @JsonSubTypes.Type(value = Text.class, name = "Text"),
        @JsonSubTypes.Type(value = List.class, name = "List"),
        @JsonSubTypes.Type(value = ListItem.class, name = "ListItem"),
        @JsonSubTypes.Type(value = Examples.class, name = "Examples"),
        @JsonSubTypes.Type(value = ExampleItem.class, name = "ExampleItem"),
        @JsonSubTypes.Type(value = Example.class, name = "Example"),
        @JsonSubTypes.Type(value = CardRefs.class, name = "CardRefs"),
        @JsonSubTypes.Type(value = CardRefItem.class, name = "CardRefItem"),
        @JsonSubTypes.Type(value = CardRef.class, name = "CardRef"),
        @JsonSubTypes.Type(value = Transcription.class, name = "Transcription"),
        @JsonSubTypes.Type(value = Abbrev.class, name = "Abbrev"),
        @JsonSubTypes.Type(value = Caption.class, name = "Caption"),
        @JsonSubTypes.Type(value = Sound.class, name = "Sound"),
        @JsonSubTypes.Type(value = Ref.class, name = "Ref"),
        @JsonSubTypes.Type(value = Unsupported.class, name = "Unsupported")})
public class ArticleNode {
    @JsonProperty("Node")
    protected NodeType node;
    @JsonProperty("Text")
    protected String text;
    @JsonProperty("IsOptional")
    protected boolean isOptional;

    public NodeType getNode() {
        return node;
    }

    public void setNode(NodeType node) {
        this.node = node;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isOptional() {
        return isOptional;
    }

    public void setOptional(boolean optional) {
        isOptional = optional;
    }

    @Override
    public String toString() {
        return "ArticleNode{" +
                "node=" + node +
                ", text='" + text + '\'' +
                ", isOptional=" + isOptional +
                '}';
    }
}
