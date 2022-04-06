package com.supinfo.formation.service;

import com.supinfo.formation.dto.ProfesseurDto;
import com.supinfo.formation.mapper.ProfesseurMapper;
import com.supinfo.formation.model.Professeur;
import com.supinfo.formation.repository.ProfesseurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class ProfesseurService {
    private final ProfesseurRepository repository;
    private final ProfesseurMapper professeurMapper;

    @Autowired
    public ProfesseurService(ProfesseurRepository repository, ProfesseurMapper professeurMapper) {
        this.repository = repository;
        this.professeurMapper = professeurMapper;
    }

    public ProfesseurDto save(ProfesseurDto professeurDto) {
        Professeur entity = professeurMapper.toEntity(professeurDto);
        return professeurMapper.toDto(repository.save(entity));
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public ProfesseurDto findById(long id) {
        return professeurMapper.toDto(repository.findById(id).orElse(null));
    }

    public Page<ProfesseurDto> findByCondition(ProfesseurDto professeurDto, Pageable pageable) {
        Page<Professeur> entityPage = repository.findAll(pageable);
        List<Professeur> entities = entityPage.getContent();
        return new PageImpl<>(professeurMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ProfesseurDto update(ProfesseurDto professeurDto, long id) {
        ProfesseurDto data = findById(id);
        Professeur entity = professeurMapper.toEntity(professeurDto);
        BeanUtils.copyProperties(data, entity);
        return save(professeurMapper.toDto(entity));
    }
}