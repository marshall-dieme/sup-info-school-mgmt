package com.supinfo.formation.mapper;

import com.supinfo.formation.dto.ProfesseurDto;
import com.supinfo.formation.model.Professeur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfesseurMapper extends EntityMapper<ProfesseurDto, Professeur> {
}