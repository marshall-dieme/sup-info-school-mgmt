package com.supinfo.formation.mapper;

import com.supinfo.formation.dto.FicheFormationDto;
import com.supinfo.formation.model.FicheFormation;
import com.supinfo.formation.service.FicheFormationService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = FicheFormationService.class)
public interface FicheFormationMapper extends EntityMapper<FicheFormationDto, FicheFormation> {
}