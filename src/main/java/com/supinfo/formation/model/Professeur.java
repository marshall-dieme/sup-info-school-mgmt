package com.supinfo.formation.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "professeurs")
public class Professeur extends Personne {
    @Column(unique = true)
    private String matricule;

    private List<Cours> cours;

    public Professeur() {
    }

    public Professeur(long id, String nom, String prenom, String telephone, String email, String matricule, List<Cours> cours) {
        super(id, nom, prenom, telephone, email);
        this.matricule = matricule;
        this.cours = cours;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
}
