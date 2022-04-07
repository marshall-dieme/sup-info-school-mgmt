package com.supinfo.formation.dto;

import com.supinfo.formation.model.Cours;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@ApiModel()
@NoArgsConstructor
@Getter
@Setter
public class ModuleDto extends AbstractDto<Long> {
    private long id;
    private String intitule;
    private List<Cours> cours;
}