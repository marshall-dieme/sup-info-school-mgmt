package com.supinfo.formation.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "fiches_formation")
public class FicheFormation {
    @Id
    @Column(unique = true, length = 50)
    private String reference;
    @ElementCollection
    @CollectionTable(name = "jours_de_cours", joinColumns = @JoinColumn(name = "formation_id"))
    @Column(name = "jour")
    private List<String> joursDeCours;

    @Column(columnDefinition = "time")
    private String heureDeDebut;

    @Column(columnDefinition = "time")
    private String heureDeFin;

    @OneToMany
    private List<Prestation> prestations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    public FicheFormation() {
    }

    public FicheFormation(String reference, List<String> joursDeCours, String heureDeDebut, String heureDeFin, List<Prestation> prestations, Etudiant etudiant) {
        this.reference = reference;
        this.joursDeCours = joursDeCours;
        this.heureDeDebut = heureDeDebut;
        this.heureDeFin = heureDeFin;
        this.prestations = prestations;
        this.etudiant = etudiant;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<String> getJoursDeCours() {
        return joursDeCours;
    }

    public void setJoursDeCours(List<String> joursDeCours) {
        this.joursDeCours = joursDeCours;
    }

    public String getHeureDeDebut() {
        return heureDeDebut;
    }

    public void setHeureDeDebut(String heureDeDebut) {
        this.heureDeDebut = heureDeDebut;
    }

    public String getHeureDeFin() {
        return heureDeFin;
    }

    public void setHeureDeFin(String heureDeFin) {
        this.heureDeFin = heureDeFin;
    }

    public List<Prestation> getPrestations() {
        return prestations;
    }

    public void setPrestations(List<Prestation> prestations) {
        this.prestations = prestations;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
