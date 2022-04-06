package com.supinfo.formation.mapper;

import com.supinfo.formation.dto.PrestationDto;
import com.supinfo.formation.model.Prestation;
import com.supinfo.formation.service.PrestationService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PrestationService.class)
public interface PrestationMapper extends EntityMapper<PrestationDto, Prestation> {
}