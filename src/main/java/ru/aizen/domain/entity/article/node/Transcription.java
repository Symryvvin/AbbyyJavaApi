package ru.aizen.domain.entity.article.node;

public class Transcription extends ArticleNode {

    public Transcription() {
        node = NodeType.TRANSCRIPTION;
    }

    public String getTranscription() {
        return "[" + text + "]";
    }

    @Override
    public String toString() {
        return "Transcription{" +
                "node=" + node +
                ", text='" + text + '\'' +
                ", isOptional=" + isOptional +
                '}';
    }

}
