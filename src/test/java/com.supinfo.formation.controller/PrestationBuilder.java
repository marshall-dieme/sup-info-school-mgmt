package com.supinfo.formation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supinfo.formation.dto.PrestationDto;

import java.util.Collections;
import java.util.List;

public class PrestationBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static PrestationDto getDto() {
        PrestationDto dto = new PrestationDto();
        dto.setId(1);
        return dto;
    }
}