package ru.aizen.domain;

import ru.aizen.domain.translate.Dictionary;
import ru.aizen.domain.translate.TranslateDirection;
import ru.aizen.domain.translate.Translation;

public final class AbbyyBuilder {
    private AbbyyClient client;
    private Dictionary dictionary;
    private TranslateDirection direction;

    private AbbyyBuilder() {
    }

    public static AbbyyBuilder create() {
        return new AbbyyBuilder();
    }

    public AbbyyBuilder setClient(AbbyyClient client) {
        this.client = client;
        return this;
    }

    public AbbyyBuilder setTranslation(Translation translation) {
        if (translation instanceof Dictionary) {
            this.dictionary = (Dictionary) translation;
        }
        if (translation instanceof TranslateDirection) {
            this.direction = (TranslateDirection) translation;
        }
        return this;
    }

    public Abbyy build() {
        if (dictionary != null)
            return new Abbyy(client, dictionary);
        return new Abbyy(client, direction);
    }
}
