package com.supinfo.formation.controller;

import com.supinfo.formation.dto.PrestationDto;
import com.supinfo.formation.mapper.PrestationMapper;
import com.supinfo.formation.model.Prestation;
import com.supinfo.formation.service.PrestationService;
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

@RequestMapping("/api/prestation")
@RestController
@Api("prestation")
public class PrestationController {
    private final PrestationService prestationService;
    private final Logger log = LoggerFactory.getLogger(ModuleController.class);
    public PrestationController(PrestationService prestationService) {
        this.prestationService = prestationService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated PrestationDto prestationDto) {
        prestationService.save(prestationDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestationDto> findById(@PathVariable("id") long id) {
        PrestationDto prestation = prestationService.findById(id);
        return ResponseEntity.ok(prestation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        Optional.ofNullable(prestationService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return null;
        });
        prestationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<PrestationDto>> pageQuery(PrestationDto prestationDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PrestationDto> prestationPage = prestationService.findByCondition(prestationDto, pageable);
        return ResponseEntity.ok(prestationPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated PrestationDto prestationDto, @PathVariable("id") long id) {
        prestationService.update(prestationDto, id);
        return ResponseEntity.ok().build();
    }
}