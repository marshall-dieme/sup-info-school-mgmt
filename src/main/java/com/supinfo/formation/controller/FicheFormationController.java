package com.supinfo.formation.controller;


import com.supinfo.formation.dto.FicheFormationDto;
import com.supinfo.formation.mapper.FicheFormationMapper;
import com.supinfo.formation.model.FicheFormation;
import com.supinfo.formation.service.FicheFormationService;
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

@RequestMapping("/fiche-formation")
@RestController
@Api("fiche-formation")
public class FicheFormationController {
    private final FicheFormationService ficheFormationService;
    private final Logger log = LoggerFactory.getLogger(FicheFormationController.class);

    public FicheFormationController(FicheFormationService ficheFormationService) {
        this.ficheFormationService = ficheFormationService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated FicheFormationDto ficheFormationDto) {
        ficheFormationService.save(ficheFormationDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FicheFormationDto> findById(@PathVariable("id") String id) {
        FicheFormationDto ficheFormation = ficheFormationService.findById(id);
        return ResponseEntity.ok(ficheFormation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(ficheFormationService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return new RuntimeException();
        });
        ficheFormationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<FicheFormationDto>> pageQuery(FicheFormationDto ficheFormationDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<FicheFormationDto> ficheFormationPage = ficheFormationService.findByCondition(ficheFormationDto, pageable);
        return ResponseEntity.ok(ficheFormationPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated FicheFormationDto ficheFormationDto, @PathVariable("id") String id) {
        ficheFormationService.update(ficheFormationDto, id);
        return ResponseEntity.ok().build();
    }
}