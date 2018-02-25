package ru.aizen.domain.entity.article.node;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sound extends ArticleNode {
    @JsonProperty("FileName")
    private String fileName;

    public Sound() {
        node = NodeType.SOUND;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Sound{" +
                "fileName='" + fileName + '\'' +
                ", node=" + node +
                ", text='" + text + '\'' +
                ", isOptional=" + isOptional +
                '}';
    }
}
