package com.supinfo.formation.dto;

import com.supinfo.formation.model.Cours;
import com.supinfo.formation.model.DetailPrestation;
import com.supinfo.formation.model.FicheFormation;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@ApiModel()
@NoArgsConstructor
@Getter
@Setter
public class PrestationDto extends AbstractDto<Long> {
    private long id;
    private List<DetailPrestation> detailPrestations;
    private List<Cours> cours;
    private FicheFormation ficheFormation;
}