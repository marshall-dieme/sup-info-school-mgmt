package com.supinfo.formation.dto;

import com.supinfo.formation.annotation.CheckDate;
import com.supinfo.formation.model.Prestation;
import io.swagger.annotations.ApiModel;

import java.time.LocalDate;
import java.util.Date;

@ApiModel()
public class DetailPrestationDto extends AbstractDto<Long> {
    private long id;
    @CheckDate
    private Date date;
    private String duree;
    private Prestation prestation;

    public DetailPrestationDto() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDuree() {
        return this.duree;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

    public Prestation getPrestation() {
        return this.prestation;
    }
}