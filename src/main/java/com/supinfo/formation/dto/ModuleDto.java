package com.supinfo.formation.dto;

import com.supinfo.formation.model.Cours;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel()
public class ModuleDto extends AbstractDto<Long> {
    private long id;
    private String intitule;
    private List<Cours> cours;

    public ModuleDto() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getIntitule() {
        return this.intitule;
    }

    public void setCours(java.util.List<com.supinfo.formation.model.Cours> cours) {
        this.cours = cours;
    }

    public java.util.List<com.supinfo.formation.model.Cours> getCours() {
        return this.cours;
    }
}