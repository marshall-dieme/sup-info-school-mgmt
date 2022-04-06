package com.supinfo.formation.mapper;

import com.supinfo.formation.dto.CoursDto;
import com.supinfo.formation.model.Cours;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoursMapper extends EntityMapper<CoursDto, Cours> {
}