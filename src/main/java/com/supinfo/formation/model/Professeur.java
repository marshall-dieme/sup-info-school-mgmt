package com.supinfo.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
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

    @Override
    public String toString() {
        return "Professeur{" +
                super.toString() +
                "matricule='" + matricule + '\'' +
                '}';
    }
}
