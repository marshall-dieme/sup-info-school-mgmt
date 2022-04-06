package com.supinfo.formation.mapper;

import com.supinfo.formation.dto.ModuleDto;
import com.supinfo.formation.model.Module;
import com.supinfo.formation.service.ModuleService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ModuleService.class)
public interface ModuleMapper extends EntityMapper<ModuleDto, Module> {
}