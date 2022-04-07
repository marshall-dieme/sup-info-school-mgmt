package com.supinfo.formation.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "modules")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String intitule;
    @OneToMany
    List<Cours> cours;
}
