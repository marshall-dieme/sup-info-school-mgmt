package com.supinfo.formation.service;

import com.supinfo.formation.dto.EtudiantDto;
import com.supinfo.formation.mapper.EtudiantMapper;
import com.supinfo.formation.mapper.EtudiantMapper;
import com.supinfo.formation.model.Etudiant;
import com.supinfo.formation.repository.EtudiantRepository;
import com.supinfo.formation.repository.EtudiantRepository;
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
public class EtudiantService {
    private final EtudiantRepository repository;
    private final EtudiantMapper etudiantMapper;

    @Autowired
    public EtudiantService(EtudiantRepository repository, EtudiantMapper etudiantMapper) {
        this.repository = repository;
        this.etudiantMapper = etudiantMapper;
    }

    public EtudiantDto save(EtudiantDto etudiantDto) {
        Etudiant entity = etudiantMapper.toEntity(etudiantDto);
        return etudiantMapper.toDto(repository.save(entity));
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public EtudiantDto findById(long id) {
        return etudiantMapper.toDto(repository.findById(id).orElse(null));
    }

    public Page<EtudiantDto> findByCondition(EtudiantDto etudiantDto, Pageable pageable) {
        Page<Etudiant> entityPage = repository.findAll(pageable);
        List<Etudiant> entities = entityPage.getContent();
        return new PageImpl<>(etudiantMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public EtudiantDto update(EtudiantDto etudiantDto, long id) {
        EtudiantDto data = findById(id);
        Etudiant entity = etudiantMapper.toEntity(etudiantDto);
        BeanUtils.copyProperties(data, entity);
        return save(etudiantMapper.toDto(entity));
    }
}