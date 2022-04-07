package com.supinfo.formation.model;

import com.supinfo.formation.enums.TypeCours;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nom;

    private String volumeHoraire;

    @ManyToMany
    private List<Etudiant> etudiants;
    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    @ManyToOne
    private Module module;

    private TypeCours typeCours;

    public Cours() {
    }

    public Cours(long id, String nom, String volumeHoraire, List<Etudiant> etudiants, Professeur professeur, Module module, TypeCours typeCours) {
        this.id = id;
        this.nom = nom;
        this.volumeHoraire = volumeHoraire;
        this.etudiants = etudiants;
        this.professeur = professeur;
        this.module = module;
        this.typeCours = typeCours;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(String volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public TypeCours getTypeCours() {
        return typeCours;
    }

    public void setTypeCours(TypeCours typeCours) {
        this.typeCours = typeCours;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", volumeHoraire='" + volumeHoraire + '\'' +
                ", etudiants=" + etudiants +
                ", professeur=" + professeur +
                '}';
    }
}
