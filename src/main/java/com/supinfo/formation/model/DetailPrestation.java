package com.supinfo.formation.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "detail_prestation")
public class DetailPrestation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(columnDefinition = "date")
    private LocalDate date;

    private String duree;

    @ManyToOne
    @JoinColumn(name = "prestation_id")
    private Prestation prestation;

    public DetailPrestation() {
    }

    public DetailPrestation(long id, LocalDate date, String duree, Prestation prestation) {
        this.id = id;
        this.date = date;
        this.duree = duree;
        this.prestation = prestation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

    @Override
    public String toString() {
        return "DetailPrestation{" +
                "id=" + id +
                ", date=" + date +
                ", duree='" + duree + '\'' +
                ", prestation=" + prestation +
                '}';
    }
}
