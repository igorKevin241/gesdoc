package com.igor.gesdoc.enums;

public enum Role {
    CHEF_DE_SERVICE("CHEF_DE_SERVICE"),
    CHEF_DE_SECTION("CHEF_DE_SECTION"),
    AGENT_EXECUTION("AGENT_EXECUTION"),
    DIRECTEUR_ADJOINT("DIRECTEUR_ADJOINT"),
    DIRECTEUR("DIRECTEUR");

    private final String value;


    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
