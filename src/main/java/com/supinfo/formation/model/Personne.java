package com.supinfo.formation.model;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    @Column(length = 20, unique = true)
    private String telephone;
    @Column(unique = true)
    private String email;
}
