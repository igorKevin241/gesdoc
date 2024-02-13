package com.igor.gesdoc.enums;

public enum TypeCorrespondance {
    COURRIER("COURRIER"),
    INSTRUCTIONS("INSTRUCTIONS"),
    RECOMMANDATIONS_DGCG("RECOMMANDATIONS_DGCG"),
    RECOMMANDATIONS_CAC("RECOMMANDATIONS_CAC");

    private final String value;

    TypeCorrespondance(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
