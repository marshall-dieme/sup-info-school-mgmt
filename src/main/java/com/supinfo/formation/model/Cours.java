package com.supinfo.formation.model;

import com.supinfo.formation.enums.TypeCours;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nom;

    private String volumeHoraire;

    @ManyToMany
    private List<Etudiant> etudiants;
    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    @ManyToOne
    private Module module;

    private TypeCours typeCours;

}
