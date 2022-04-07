package com.supinfo.formation.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "prestations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Prestation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<DetailPrestation> detailPrestations;
    @OneToMany
    private List<Cours> cours;

    @ManyToOne
    @JoinColumn(name = "fiche_formation_reference")
    private FicheFormation ficheFormation;

}
