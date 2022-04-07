package com.supinfo.formation.mapper;

import com.supinfo.formation.dto.ProfesseurDto;
import com.supinfo.formation.model.Professeur;
import com.supinfo.formation.service.ProfesseurService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ProfesseurService.class)
public interface ProfesseurMapper extends EntityMapper<ProfesseurDto, Professeur> {
}