package com.supinfo.formation.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "professeurs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Professeur extends Personne {
    @Column(unique = true)
    private String matricule;

}
