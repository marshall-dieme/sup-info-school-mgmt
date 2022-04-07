package com.supinfo.formation.dto;

import com.supinfo.formation.annotation.CheckEmail;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@ApiModel()
@NoArgsConstructor
@Getter
@Setter
public class ProfesseurDto extends AbstractDto<Long> {

    private long id;
    private String nom;
    private String prenom;
    private String telephone;
    @Email
    private String email;
    @Size(max = 255)
    private String matricule;
}