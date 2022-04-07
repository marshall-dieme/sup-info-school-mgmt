package com.supinfo.formation.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "fiches_formation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FicheFormation {
    @Id
    @Column(unique = true, length = 50)
    private String reference;
    @ElementCollection
    @CollectionTable(name = "jours_de_cours", joinColumns = @JoinColumn(name = "formation_id"))
    @Column(name = "jour")
    private List<String> joursDeCours;

    @Column(columnDefinition = "time")
    private LocalTime heureDeDebut;

    @Column(columnDefinition = "time")
    private LocalTime heureDeFin;

    @OneToMany
    private List<Prestation> prestations;

    @OneToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

}
