package com.supinfo.formation.dto;

import com.supinfo.formation.annotation.CheckDate;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@ApiModel()
@NoArgsConstructor
@Getter
@Setter
public class EtudiantDto extends AbstractDto<Long> {
    private long id;
    private String nom;
    private String prenom;
    @Size(max = 20)
    private String telephone;
    @Email
    private String email;
    @CheckDate
    private LocalDate dateNaissance;
}