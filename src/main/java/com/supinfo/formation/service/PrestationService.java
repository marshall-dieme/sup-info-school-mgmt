package com.supinfo.formation.service;

import com.supinfo.formation.dto.PrestationDto;
import com.supinfo.formation.mapper.PrestationMapper;
import com.supinfo.formation.model.Prestation;
import com.supinfo.formation.repository.PrestationRepository;
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
public class PrestationService {
    private final PrestationRepository repository;
    private final PrestationMapper prestationMapper;

    @Autowired
    public PrestationService(PrestationRepository repository, PrestationMapper prestationMapper) {
        this.repository = repository;
        this.prestationMapper = prestationMapper;
    }

    public PrestationDto save(PrestationDto prestationDto) {
        Prestation entity = prestationMapper.toEntity(prestationDto);
        return prestationMapper.toDto(repository.save(entity));
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public PrestationDto findById(long id) {
        return prestationMapper.toDto(repository.findById(id).orElse(null));
    }

    public Page<PrestationDto> findByCondition(PrestationDto prestationDto, Pageable pageable) {
        Page<Prestation> entityPage = repository.findAll(pageable);
        List<Prestation> entities = entityPage.getContent();
        return new PageImpl<>(prestationMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public PrestationDto update(PrestationDto prestationDto, long id) {
        PrestationDto data = findById(id);
        Prestation entity = prestationMapper.toEntity(prestationDto);
        BeanUtils.copyProperties(data, entity);
        return save(prestationMapper.toDto(entity));
    }
}