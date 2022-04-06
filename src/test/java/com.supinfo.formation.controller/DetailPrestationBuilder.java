package com.supinfo.formation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supinfo.formation.dto.DetailPrestationDto;

import java.util.Collections;
import java.util.List;

public class DetailPrestationBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static DetailPrestationDto getDto() {
        DetailPrestationDto dto = new DetailPrestationDto();
        dto.setId(1);
        return dto;
    }
}