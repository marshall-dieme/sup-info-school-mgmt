package com.supinfo.formation.model;

import javax.persistence.*;
import java.util.List;

@Entity
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

    public Prestation(long id, List<DetailPrestation> detailPrestations, FicheFormation ficheFormation, List<Cours> cours) {
        this.id = id;
        this.detailPrestations = detailPrestations;
        this.ficheFormation = ficheFormation;
        this.cours = cours;
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

    @Override
    public String toString() {
        return "Prestation{" +
                "id=" + id +
                ", detailPrestations=" + detailPrestations +
                '}';
    }
}
