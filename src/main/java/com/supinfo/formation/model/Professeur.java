package com.supinfo.formation.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "professeurs")
public class Professeur extends Personne {
    @Column(unique = true)
    private String matricule;

    public Professeur() {
    }

    public Professeur(long id, String nom, String prenom, String telephone, String email, String matricule) {
        super(id, nom, prenom, telephone, email);
        this.matricule = matricule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}
