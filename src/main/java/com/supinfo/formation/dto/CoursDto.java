package com.supinfo.formation.dto;

import com.supinfo.formation.enums.TypeCours;
import com.supinfo.formation.model.Etudiant;
import com.supinfo.formation.model.Module;
import com.supinfo.formation.model.Professeur;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@ApiModel()
@NoArgsConstructor
@Getter
@Setter
public class CoursDto extends AbstractDto<Long> {
    private long id;
    private String nom;
    private String volumeHoraire;
    private List<Etudiant> etudiants;
    private Professeur professeur;
    private Module module;
    private TypeCours typeCours;

}