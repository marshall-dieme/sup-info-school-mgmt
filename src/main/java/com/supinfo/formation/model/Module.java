package com.supinfo.formation.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "modules")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String intitule;
    @OneToMany(cascade = CascadeType.ALL)
    List<Cours> cours;

    public Module() {
    }

    public Module(long id, String intitule, List<Cours> cours) {
        this.id = id;
        this.intitule = intitule;
        this.cours = cours;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
}
