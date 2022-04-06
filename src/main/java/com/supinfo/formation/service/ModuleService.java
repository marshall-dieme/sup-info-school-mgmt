package com.supinfo.formation.service;

import com.supinfo.formation.dto.ModuleDto;
import com.supinfo.formation.mapper.ModuleMapper;
import com.supinfo.formation.model.Module;
import com.supinfo.formation.repository.ModuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ModuleService {
    private final ModuleRepository repository;
    private final ModuleMapper moduleMapper;

    @Autowired
    public ModuleService(ModuleRepository repository, ModuleMapper moduleMapper) {
        this.repository = repository;
        this.moduleMapper = moduleMapper;
    }

    public ModuleDto save(ModuleDto moduleDto) {
        Module entity = moduleMapper.toEntity(moduleDto);
        return moduleMapper.toDto(repository.save(entity));
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public ModuleDto findById(long id) {
        return moduleMapper.toDto(repository.findById(id).orElse(null));
    }

    public Page<ModuleDto> findByCondition(ModuleDto moduleDto, Pageable pageable) {
        Page<Module> entityPage = repository.findAll(pageable);
        List<Module> entities = entityPage.getContent();
        return new PageImpl<>(moduleMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ModuleDto update(ModuleDto moduleDto, long id) {
        ModuleDto data = findById(id);
        Module entity = moduleMapper.toEntity(moduleDto);
        BeanUtils.copyProperties(data, entity);
        return save(moduleMapper.toDto(entity));
    }
}