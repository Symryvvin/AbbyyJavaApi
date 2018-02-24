package ru.aizen.domain;

public enum Language {
    EN(1033),
    RU(1049),
    FR(1036),
    DE(1031),
    IT(1040),
    KK(1087),
    ES(1034),
    UK(1058),
    CH(1028),
    EL(1032),
    PL(1045),
    TT(1092),
    DA(1030),
    LA(1142);

    private Integer code;

    Language(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
