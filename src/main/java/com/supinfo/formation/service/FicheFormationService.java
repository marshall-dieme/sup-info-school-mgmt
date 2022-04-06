package com.supinfo.formation.service;

import com.supinfo.formation.dto.FicheFormationDto;
import com.supinfo.formation.mapper.FicheFormationMapper;
import com.supinfo.formation.model.FicheFormation;
import com.supinfo.formation.repository.FicheFormationRepository;
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
public class FicheFormationService {
    private final FicheFormationRepository repository;
    private final FicheFormationMapper ficheFormationMapper;

    @Autowired
    public FicheFormationService(FicheFormationRepository repository, FicheFormationMapper ficheFormationMapper) {
        this.repository = repository;
        this.ficheFormationMapper = ficheFormationMapper;
    }

    public FicheFormationDto save(FicheFormationDto ficheFormationDto) {
        FicheFormation entity = ficheFormationMapper.toEntity(ficheFormationDto);
        return ficheFormationMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public FicheFormationDto findById(String id) {
        return ficheFormationMapper.toDto(repository.findById(id).orElse(null));
    }

    public Page<FicheFormationDto> findByCondition(FicheFormationDto ficheFormationDto, Pageable pageable) {
        Page<FicheFormation> entityPage = repository.findAll(pageable);
        List<FicheFormation> entities = entityPage.getContent();
        return new PageImpl<>(ficheFormationMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public FicheFormationDto update(FicheFormationDto ficheFormationDto, String id) {
        FicheFormationDto data = findById(id);
        FicheFormation entity = ficheFormationMapper.toEntity(ficheFormationDto);
        BeanUtils.copyProperties(data, entity);
        return save(ficheFormationMapper.toDto(entity));
    }
}