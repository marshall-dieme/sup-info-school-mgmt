package com.supinfo.formation.dto;

import com.supinfo.formation.annotation.CheckDate;
import com.supinfo.formation.enums.JoursDeCours;
import com.supinfo.formation.model.Prestation;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.List;

@ApiModel()
public class FicheFormationDto extends AbstractDto<String> {
    @Size(max = 50)
    private String reference;
    private List<JoursDeCours> joursDeCours;
    @CheckDate
    private LocalTime heureDeDebut;
    @CheckDate
    private LocalTime heureDeFin;
    private List<Prestation> prestations;

    public FicheFormationDto() {
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return this.reference;
    }

    public void setJoursDeCours(List<JoursDeCours> joursDeCours) {
        this.joursDeCours = joursDeCours;
    }

    public List<JoursDeCours> getJoursDeCours() {
        return this.joursDeCours;
    }

    public void setHeureDeDebut(LocalTime heureDeDebut) {
        this.heureDeDebut = heureDeDebut;
    }

    public LocalTime getHeureDeDebut() {
        return this.heureDeDebut;
    }

    public void setHeureDeFin(LocalTime heureDeFin) {
        this.heureDeFin = heureDeFin;
    }

    public LocalTime getHeureDeFin() {
        return this.heureDeFin;
    }

    public void setPrestations(List<Prestation> prestations) {
        this.prestations = prestations;
    }

    public java.util.List<com.supinfo.formation.model.Prestation> getPrestations() {
        return this.prestations;
    }
}