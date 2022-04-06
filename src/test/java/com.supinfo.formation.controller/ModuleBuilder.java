package com.supinfo.formation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supinfo.formation.dto.ModuleDto;

import java.util.Collections;
import java.util.List;

public class ModuleBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ModuleDto getDto() {
        ModuleDto dto = new ModuleDto();
        dto.setId(1);
        return dto;
    }
}