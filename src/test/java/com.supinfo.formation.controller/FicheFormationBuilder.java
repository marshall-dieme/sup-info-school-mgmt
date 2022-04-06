package com.supinfo.formation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supinfo.formation.dto.FicheFormationDto;

import java.util.Collections;
import java.util.List;

public class FicheFormationBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static FicheFormationDto getDto() {
        FicheFormationDto dto = new FicheFormationDto();
        dto.setReference("1");
        return dto;
    }
}