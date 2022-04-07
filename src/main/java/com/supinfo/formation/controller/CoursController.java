package com.supinfo.formation.controller;


import com.supinfo.formation.dto.CoursDto;
import com.supinfo.formation.mapper.CoursMapper;
import com.supinfo.formation.model.Cours;
import com.supinfo.formation.service.CoursService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/cours")
@RestController
@Api("cours")
public class CoursController {
    private final CoursService coursService;

    private final Logger log = LoggerFactory.getLogger(ModuleController.class);

    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated CoursDto coursDto) {
        coursService.save(coursDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursDto> findById(@PathVariable("id") long id) {
        CoursDto cours = coursService.findById(id);
        return ResponseEntity.ok(cours);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        Optional.ofNullable(coursService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return null;
        });
        coursService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<CoursDto>> pageQuery(CoursDto coursDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<CoursDto> coursPage = coursService.findByCondition(coursDto, pageable);
        return ResponseEntity.ok(coursPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated CoursDto coursDto, @PathVariable("id") long id) {
        coursService.update(coursDto, id);
        return ResponseEntity.ok().build();
    }
}