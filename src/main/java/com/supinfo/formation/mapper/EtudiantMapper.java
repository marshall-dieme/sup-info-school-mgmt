package com.supinfo.formation.mapper;

import com.supinfo.formation.dto.EtudiantDto;
import com.supinfo.formation.model.Etudiant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtudiantMapper extends EntityMapper<EtudiantDto, Etudiant> {
}