package com.supinfo.formation.dto;

import com.supinfo.formation.enums.TypeCours;
import com.supinfo.formation.model.Etudiant;
import com.supinfo.formation.model.Module;
import com.supinfo.formation.model.Professeur;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel()
public class CoursDto extends AbstractDto<Long> {
    private long id;
    private String nom;
    private String volumeHoraire;
    private List<Etudiant> etudiants;
    private Professeur professeur;
    private Module module;
    private TypeCours typeCours;

    public CoursDto() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setVolumeHoraire(String volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public String getVolumeHoraire() {
        return this.volumeHoraire;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public java.util.List<Etudiant> getEtudiants() {
        return this.etudiants;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Professeur getProfesseur() {
        return this.professeur;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return this.module;
    }

    public void setTypeCours(TypeCours typeCours) {
        this.typeCours = typeCours;
    }

    public TypeCours getTypeCours() {
        return this.typeCours;
    }
}