package com.supinfo.formation.dto;

import com.supinfo.formation.model.Etudiant;
import com.supinfo.formation.model.Prestation;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.Size;
import java.util.List;

@ApiModel()
public class FicheFormationDto extends AbstractDto<String> {
    @Size(max = 50)
    private String reference;
    private List<String> joursDeCours;
    @Size(max = 255)
    private String heureDeDebut;
    @Size(max = 255)
    private String heureDeFin;
    private List<Prestation> prestations;
    private Etudiant etudiant;

    public FicheFormationDto() {
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return this.reference;
    }

    public void setJoursDeCours(java.util.List<String> joursDeCours) {
        this.joursDeCours = joursDeCours;
    }

    public java.util.List<String> getJoursDeCours() {
        return this.joursDeCours;
    }

    public void setHeureDeDebut(String heureDeDebut) {
        this.heureDeDebut = heureDeDebut;
    }

    public String getHeureDeDebut() {
        return this.heureDeDebut;
    }

    public void setHeureDeFin(String heureDeFin) {
        this.heureDeFin = heureDeFin;
    }

    public String getHeureDeFin() {
        return this.heureDeFin;
    }

    public void setPrestations(java.util.List<com.supinfo.formation.model.Prestation> prestations) {
        this.prestations = prestations;
    }

    public java.util.List<com.supinfo.formation.model.Prestation> getPrestations() {
        return this.prestations;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Etudiant getEtudiant() {
        return this.etudiant;
    }
}