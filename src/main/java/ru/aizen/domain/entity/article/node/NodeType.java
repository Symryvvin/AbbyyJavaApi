package ru.aizen.domain.entity.article.node;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum NodeType {
    @JsonProperty("Comment")
    COMMENT(0, "Comment"),
    @JsonProperty("Paragraph")
    PARAGRAPH(1, "Paragraph"),
    @JsonProperty("Text")
    TEXT(2, "plain text"),
    @JsonProperty("List")
    LIST(3, " List"),
    @JsonProperty("ListItem")
    LISTITEM(4, " List item"),
    @JsonProperty("Examples")
    EXAMPLES(5, " Examples"),
    @JsonProperty("ExampleItem")
    EXAMPLEITEM(6, "Examples list item"),
    @JsonProperty("Example")
    EXAMPLE(7, "Example"),
    @JsonProperty("CardRef")
    CARDREFS(8, "Cards references"),
    @JsonProperty("CardRefItem")
    CARDREFITEM(9, "Card reference list item"),
    @JsonProperty("CardRef")
    CARDREF(10, "Card reference"),
    @JsonProperty("Transcription")
    TRANSCRIPTION(11, "Transcription"),
    @JsonProperty("Abbrev")
    ABBREV(12, "Abbreviation"),
    @JsonProperty("Caption")
    CAPTION(13, "Caption"),
    @JsonProperty("Sound")
    SOUND(14, "Sound file link"),
    @JsonProperty("Ref")
    REF(15, "Reference"),
    @JsonProperty("Unsupported")
    UNSUPPORTED(16, "Unsupported element type");


    private int number;
    private String description;

    NodeType(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
