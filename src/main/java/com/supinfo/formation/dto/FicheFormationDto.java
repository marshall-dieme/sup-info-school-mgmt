package com.supinfo.formation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.supinfo.formation.annotation.CheckDate;
import com.supinfo.formation.enums.JoursDeCours;
import com.supinfo.formation.model.Prestation;
import com.supinfo.formation.utils.LocalTimeDeserializer;
import io.swagger.annotations.ApiModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@ApiModel()
public class FicheFormationDto extends AbstractDto<String> {
    @Size(max = 50)
    private String reference;

    private List<JoursDeCours> joursDeCours;
    @CheckDate
    @DateTimeFormat(style = "hh:mm")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private Date heureDeDebut;
    @CheckDate
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private Date heureDeFin;
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

    public void setHeureDeDebut(Date heureDeDebut) {
        this.heureDeDebut = heureDeDebut;
    }

    public Date getHeureDeDebut() {
        return this.heureDeDebut;
    }

    public void setHeureDeFin(Date heureDeFin) {
        this.heureDeFin = heureDeFin;
    }

    public Date getHeureDeFin() {
        return this.heureDeFin;
    }

    public void setPrestations(List<Prestation> prestations) {
        this.prestations = prestations;
    }

    public java.util.List<com.supinfo.formation.model.Prestation> getPrestations() {
        return this.prestations;
    }
}