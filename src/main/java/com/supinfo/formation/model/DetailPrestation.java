package com.supinfo.formation.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "details_prestations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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
}
