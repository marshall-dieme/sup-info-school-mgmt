package com.supinfo.formation.model;


import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "fiche_formation")
public class FicheFormation {
    @Id
    @Column(unique = true, length = 50)
    private String reference;


    @ElementCollection
    @CollectionTable(name = "jours_de_cours", joinColumns = @JoinColumn(name = "formation_id"))
    @Column(name = "jour")
    private List<String> joursDeCours;

    @Column(columnDefinition = "time")
    private LocalTime heureDeDebut;

    @Column(columnDefinition = "time")
    private LocalTime heureDeFin;

    @OneToMany
    private List<Prestation> prestations;

    @OneToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public FicheFormation() {
    }

    public FicheFormation(String reference, List<String> joursDeCours, LocalTime heureDeDebut, LocalTime heureDeFin, List<Prestation> prestations) {
        this.reference = reference;
        this.joursDeCours = joursDeCours;
        this.heureDeDebut = heureDeDebut;
        this.heureDeFin = heureDeFin;
        this.prestations = prestations;
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

    public LocalTime getHeureDeDebut() {
        return heureDeDebut;
    }

    public void setHeureDeDebut(LocalTime heureDeDebut) {
        this.heureDeDebut = heureDeDebut;
    }

    public LocalTime getHeureDeFin() {
        return heureDeFin;
    }

    public void setHeureDeFin(LocalTime heureDeFin) {
        this.heureDeFin = heureDeFin;
    }

    public List<Prestation> getPrestations() {
        return prestations;
    }

    public void setPrestations(List<Prestation> prestations) {
        this.prestations = prestations;
    }

    @Override
    public String toString() {
        return "FicheFormation{" +
                "reference='" + reference + '\'' +
                ", joursDeCours=" + joursDeCours +
                ", heureDeDebut=" + heureDeDebut +
                ", heureDeFin=" + heureDeFin +
                ", prestations=" + prestations +
                '}';
    }
}
