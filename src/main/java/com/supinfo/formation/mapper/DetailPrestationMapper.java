package com.supinfo.formation.mapper;

import com.supinfo.formation.dto.DetailPrestationDto;
import com.supinfo.formation.model.DetailPrestation;
import com.supinfo.formation.service.DetailPrestationService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = DetailPrestationService.class)
public interface DetailPrestationMapper extends EntityMapper<DetailPrestationDto, DetailPrestation> {
}