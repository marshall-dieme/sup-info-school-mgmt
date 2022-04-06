package com.supinfo.formation.controller;

import com.supinfo.formation.dto.CoursDto;

import java.util.Collections;
import java.util.List;

public class CoursBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static CoursDto getDto() {
        CoursDto dto = new CoursDto();
        dto.setId(1);
        return dto;
    }
}