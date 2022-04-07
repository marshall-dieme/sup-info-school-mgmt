package com.supinfo.formation.dto;

import com.supinfo.formation.annotation.CheckDate;
import com.supinfo.formation.enums.JoursDeCours;
import com.supinfo.formation.model.Prestation;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.List;

@ApiModel()
@NoArgsConstructor
@Getter
@Setter
public class FicheFormationDto extends AbstractDto<String> {
    @Size(max = 50)
    private String reference;
    private List<JoursDeCours> joursDeCours;
    @CheckDate
    private LocalTime heureDeDebut;
    @CheckDate
    private LocalTime heureDeFin;
    private List<Prestation> prestations;

}