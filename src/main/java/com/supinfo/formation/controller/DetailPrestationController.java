package com.supinfo.formation.controller;


import com.supinfo.formation.dto.DetailPrestationDto;
import com.supinfo.formation.service.DetailPrestationService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/detail-prestation")
@RestController
@Api("detail-prestation")
public class DetailPrestationController {
    private final DetailPrestationService detailPrestationService;

    private final Logger log = LoggerFactory.getLogger(DetailPrestationController.class);


    public DetailPrestationController(DetailPrestationService detailPrestationService) {
        this.detailPrestationService = detailPrestationService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated DetailPrestationDto detailPrestationDto) {
        detailPrestationService.save(detailPrestationDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailPrestationDto> findById(@PathVariable("id") long id) {
        DetailPrestationDto detailPrestation = detailPrestationService.findById(id);
        return ResponseEntity.ok(detailPrestation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        Optional.ofNullable(detailPrestationService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return null;
        });
        detailPrestationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<DetailPrestationDto>> pageQuery(DetailPrestationDto detailPrestationDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<DetailPrestationDto> detailPrestationPage = detailPrestationService.findByCondition(detailPrestationDto, pageable);
        return ResponseEntity.ok(detailPrestationPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated DetailPrestationDto detailPrestationDto, @PathVariable("id") long id) {
        detailPrestationService.update(detailPrestationDto, id);
        return ResponseEntity.ok().build();
    }
}