package com.supinfo.formation.dto;

import com.supinfo.formation.annotation.CheckDate;
import com.supinfo.formation.model.Prestation;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@ApiModel()
@NoArgsConstructor
@Getter
@Setter
public class DetailPrestationDto extends AbstractDto<Long> {
    private long id;
    @CheckDate
    private LocalDate date;
    private String duree;
    private Prestation prestation;

}