package com.supinfo.formation.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "prestations")
public class Prestation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<DetailPrestation> detailPrestations;
    @OneToMany
    private List<Cours> cours;

    @ManyToOne
    @JoinColumn(name = "fiche_formation_reference")
    private FicheFormation ficheFormation;

    public Prestation() {
    }

    public Prestation(long id, List<DetailPrestation> detailPrestations, List<Cours> cours, FicheFormation ficheFormation) {
        this.id = id;
        this.detailPrestations = detailPrestations;
        this.cours = cours;
        this.ficheFormation = ficheFormation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<DetailPrestation> getDetailPrestations() {
        return detailPrestations;
    }

    public void setDetailPrestations(List<DetailPrestation> detailPrestations) {
        this.detailPrestations = detailPrestations;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public FicheFormation getFicheFormation() {
        return ficheFormation;
    }

    public void setFicheFormation(FicheFormation ficheFormation) {
        this.ficheFormation = ficheFormation;
    }
}
