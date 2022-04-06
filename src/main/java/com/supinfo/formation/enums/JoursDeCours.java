package com.supinfo.formation.enums;

public enum JoursDeCours {
    LUNDI("Lundi"),
    MARDI("Mardi"),
    MERCREDI("Mercredi"),
    JEUDI("Jeudi"),
    VENDREDI("Vendredi"),
    SAMEDI("Samedi"),
    DIMANCHE("Dimanche");

    final String nomDuJour;

    JoursDeCours(String nomDuJour) {
        this.nomDuJour = nomDuJour;
    }
}
