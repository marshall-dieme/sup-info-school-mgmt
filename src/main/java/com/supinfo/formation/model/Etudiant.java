package com.supinfo.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Etudiant extends Personne{

    @Column(columnDefinition = "date")
    private LocalDate dateNaissance;

    @OneToOne
    @JoinColumn(name = "fiche_formation_reference")
    private FicheFormation ficheFormation;

    public FicheFormation getFicheFormation() {
        return ficheFormation;
    }

    public Etudiant() {
    }

    public Etudiant(long id, String nom, String prenom, String telephone, String email, LocalDate dateNaissance) {
        super(id, nom, prenom, telephone, email);
        this.dateNaissance = dateNaissance;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return "Etudiant{" + super.toString() +
                "dateNaissance=" + dateNaissance +
                '}';
    }
}
