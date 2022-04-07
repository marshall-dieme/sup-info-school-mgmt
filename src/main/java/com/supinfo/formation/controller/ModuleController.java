package com.supinfo.formation.controller;

import com.supinfo.formation.dto.ModuleDto;
import com.supinfo.formation.mapper.ModuleMapper;
import com.supinfo.formation.model.Module;
import com.supinfo.formation.service.ModuleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
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

@RequestMapping("/api/module")
@RestController
@Slf4j
@Api("module")
public class ModuleController {
    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ModuleDto moduleDto) {
        moduleService.save(moduleDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDto> findById(@PathVariable("id") long id) {
        ModuleDto module = moduleService.findById(id);
        return ResponseEntity.ok(module);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        Optional.ofNullable(moduleService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return null;
        });
        moduleService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ModuleDto>> pageQuery(ModuleDto moduleDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ModuleDto> modulePage = moduleService.findByCondition(moduleDto, pageable);
        return ResponseEntity.ok(modulePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ModuleDto moduleDto, @PathVariable("id") long id) {
        moduleService.update(moduleDto, id);
        return ResponseEntity.ok().build();
    }
}