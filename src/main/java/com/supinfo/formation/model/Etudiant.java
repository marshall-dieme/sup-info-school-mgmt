package com.supinfo.formation.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Etudiant extends Personne{

    @Column(columnDefinition = "date")
    private LocalDate dateNaissance;

    @OneToOne
    @JoinColumn(name = "fiche_formation_reference")
    private FicheFormation ficheFormation;

    public FicheFormation getFicheFormation() {
        return ficheFormation;
    }

}
