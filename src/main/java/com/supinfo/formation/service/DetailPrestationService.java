package com.supinfo.formation.service;

import com.supinfo.formation.dto.DetailPrestationDto;
import com.supinfo.formation.mapper.DetailPrestationMapper;
import com.supinfo.formation.model.DetailPrestation;
import com.supinfo.formation.repository.DetailPrestationRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.InjectService;
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
public class DetailPrestationService {
    private final DetailPrestationRepository repository;

    private final DetailPrestationMapper detailPrestationMapper;

    @Autowired
    public DetailPrestationService(DetailPrestationRepository repository, DetailPrestationMapper detailPrestationMapper) {
        this.repository = repository;
        this.detailPrestationMapper = detailPrestationMapper;
    }

    public DetailPrestationDto save(DetailPrestationDto detailPrestationDto) {
        DetailPrestation entity = detailPrestationMapper.toEntity(detailPrestationDto);
        return detailPrestationMapper.toDto(repository.save(entity));
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public DetailPrestationDto findById(long id) {
        return detailPrestationMapper.toDto(repository.findById(id).orElse(null));
    }

    public Page<DetailPrestationDto> findByCondition(DetailPrestationDto detailPrestationDto, Pageable pageable) {
        Page<DetailPrestation> entityPage = repository.findAll(pageable);
        List<DetailPrestation> entities = entityPage.getContent();
        return new PageImpl<>(detailPrestationMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public DetailPrestationDto update(DetailPrestationDto detailPrestationDto, long id) {
        DetailPrestationDto data = findById(id);
        DetailPrestation entity = detailPrestationMapper.toEntity(detailPrestationDto);
        BeanUtils.copyProperties(data, entity);
        return save(detailPrestationMapper.toDto(entity));
    }
}