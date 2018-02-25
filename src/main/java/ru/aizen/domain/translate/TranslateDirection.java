package ru.aizen.domain.translate;

public enum TranslateDirection implements Translation{
    EN_RU (Language.EN, Language.RU),
    RU_EN(Language.RU, Language.EN),
    FR_RU(Language.FR, Language.RU),
    RU_FR(Language.RU, Language.FR),
    DE_RU(Language.DE, Language.RU),
    RU_DE(Language.RU, Language.DE),
    IT_RU(Language.IT, Language.RU),
    RU_IT(Language.RU, Language.IT),
    RU_RU(Language.RU, Language.RU),
    KK_RU(Language.KK, Language.RU),
    RU_KK(Language.RU, Language.KK),
    ES_RU(Language.ES, Language.RU),
    RU_ES(Language.RU, Language.ES),
    UK_UK(Language.UK, Language.UK),
    EN_EN(Language.EN, Language.EN),
    EN_UK(Language.EN, Language.UK),
    UK_EN(Language.UK, Language.EN),
    CH_CH(Language.CH, Language.CH),
    EL_RU(Language.EL, Language.RU),
    RU_EL(Language.RU, Language.EL),
    PL_UK(Language.PL, Language.UK),
    UK_PL(Language.UK, Language.PL),
    UK_RU(Language.UK, Language.RU),
    RU_UK(Language.RU, Language.UK),
    CH_RU(Language.CH, Language.RU),
    RU_CH(Language.RU, Language.CH),
    DA_RU(Language.DA, Language.RU),
    RU_DA(Language.RU, Language.DA),
    TT_RU(Language.TT, Language.RU),
    RU_TT(Language.RU, Language.TT),
    LA_RU(Language.LA, Language.RU),
    PL_RU(Language.PL, Language.RU),
    RU_PL(Language.RU, Language.PL);

    private Language source;
    private Language destination;

    TranslateDirection(Language source, Language destination) {
        this.source = source;
        this.destination = destination;
    }

    public Language getSource() {
        return source;
    }

    public Language getDestination() {
        return destination;
    }
}
