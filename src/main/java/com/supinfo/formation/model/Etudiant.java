package com.supinfo.formation.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Etudiant extends Personne{

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @OneToOne
    @JoinColumn(name = "fiche_formation_reference")
    private FicheFormation ficheFormation;

    @OneToOne
    public FicheFormation getFicheFormation() {
        return ficheFormation;
    }

    public Etudiant() {
    }

    public Etudiant(long id, String nom, String prenom, String telephone, String email, Date dateNaissance) {
        super(id, nom, prenom, telephone, email);
        this.dateNaissance = dateNaissance;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setFicheFormation(FicheFormation ficheFormation) {
        this.ficheFormation = ficheFormation;
    }

    @Override
    public String toString() {
        return "Etudiant{" + super.toString() +
                "dateNaissance=" + dateNaissance +
                '}';
    }
}
