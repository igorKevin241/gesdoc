package com.igor.gesdoc.enums;

public enum Correspondant {

    TOUS("TOUS"),
    PRESTATAIRES("PRESTATAIRES"),
    PERSONNEL("PERSONNEL"),
    BUREAU_DE_PARIS("BUREAU_DE_PARIS"),
    GOUVERNEUR("GOUVERNEUR"),
    VICE_GOUVERNEUR("VICE_GOUVERNEUR"),
    SECRETAIRE_GENERAL("SECRETAIRE_GENERAL"),
    DPMG("DPMG"),
    DOP("DOP"),
    DRPP("DRPP"),
    DAJR("DAJR"),
    DIRECTEUR_GENERAL_DGCG("DIRECTEUR_GENERAL_DGCG"),
    DIRECTEUR_GENERAL_DGE("DIRECTEUR_GENERAL_DGE"),
    DRHF("DRHF"),
    DSI("DSI"),
    DSMP("DSMP"),
    CGAM("CGAM"),
    DIRECTEUR_GENERAL_DGFRI("DIRECTEUR_GENERAL_DGFRI"),
    DSFABFE("DSFABFE"),
    DRI("DRI"),
    DERS("DERS"),
    DOF("DOF"),
    DN_YAOUNDE("DN_YAOUNDE"),
    AGENCE_DOUALA("AGENCE_DOUALA"),
    AGENCE_BAFOUSSAM("AGENCE_BAFOUSSAM"),
    AGENCE_GAROUA("AGENCE_GAROUA"),
    AGENCE_LIMBE("AGENCE_LIMBE"),
    AGENCE_NKONGSAMBA("AGENCE_NKONGSAMBA"),
    AGENCE_EBOLOWA("AGENCE_EBOLOWA"),
    DN_BANGUI("DN_BANGUI"),
    DN_BRAZZAVILLE("DN_BRAZZAVILLE"),
    AGENCE_POINTE_NOIRE("AGENCE_POINTE_NOIRE"),
    AGENCE_OYO("AGENCE_OYO"),
    AGENCE_OUESSO("AGENCE_OUESSO"),
    DN_LIBREVILLE("DN_LIBREVILLE"),
    AGENCE_PORT_GENTIL("AGENCE_PORT_GENTIL"),
    AGENCE_FRANCEVILLE("AGENCE_FRANCEVILLE"),
    AGENCE_OYEM("AGENCE_OYEM"),
    AGENCE_MOUILA("AGENCE_MOUILA"),
    DN_MALABO("DN_MALABO"),
    AGENCE_BATA("AGENCE_BATA"),
    AGENCE_EBIBEYIN("AGENCE_EBIBEYIN"),
    DN_NDJAMENA("DN_NDJAMENA"),
    AGENCE_MOUNDOU("AGENCE_MOUNDOU"),
    AGENCE_SARH("AGENCE_SARH"),
    AGENCE_ABECHE("AGENCE_ABECHE"),
    AGENCE_AMDJARASS("AGENCE_AMDJARASS");

    private final String value;

    public String getValue() {
        return value;
    }
    Correspondant(String value){
        this.value = value;


    }
}
