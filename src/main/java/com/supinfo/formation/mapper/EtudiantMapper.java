package com.supinfo.formation.mapper;

import com.supinfo.formation.dto.EtudiantDto;
import com.supinfo.formation.model.Etudiant;
import com.supinfo.formation.service.EtudiantService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = EtudiantService.class)
public interface EtudiantMapper extends EntityMapper<EtudiantDto, Etudiant> {
}