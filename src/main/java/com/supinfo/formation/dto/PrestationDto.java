package com.supinfo.formation.dto;

import com.supinfo.formation.model.Cours;
import com.supinfo.formation.model.DetailPrestation;
import com.supinfo.formation.model.FicheFormation;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel()
public class PrestationDto extends AbstractDto<Long> {
    private long id;
    private List<DetailPrestation> detailPrestations;
    private List<Cours> cours;
    private FicheFormation ficheFormation;

    public PrestationDto() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setDetailPrestations(java.util.List<com.supinfo.formation.model.DetailPrestation> detailPrestations) {
        this.detailPrestations = detailPrestations;
    }

    public java.util.List<com.supinfo.formation.model.DetailPrestation> getDetailPrestations() {
        return this.detailPrestations;
    }

    public void setCours(java.util.List<com.supinfo.formation.model.Cours> cours) {
        this.cours = cours;
    }

    public java.util.List<com.supinfo.formation.model.Cours> getCours() {
        return this.cours;
    }

    public void setFicheFormation(FicheFormation ficheFormation) {
        this.ficheFormation = ficheFormation;
    }

    public FicheFormation getFicheFormation() {
        return this.ficheFormation;
    }
}