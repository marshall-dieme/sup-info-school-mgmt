package com.supinfo.formation.service;

import com.supinfo.formation.dto.CoursDto;
import com.supinfo.formation.mapper.CoursMapper;
import com.supinfo.formation.model.Cours;
import com.supinfo.formation.repository.CoursRepository;
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

@Service
@Slf4j
@Transactional
public class CoursService {
    private final CoursRepository repository;
    private final CoursMapper coursMapper;

    @Autowired
    public CoursService(CoursRepository repository, CoursMapper coursMapper) {
        this.repository = repository;
        this.coursMapper = coursMapper;
    }

    public CoursDto save(CoursDto coursDto) {
        Cours entity = coursMapper.toEntity(coursDto);
        return coursMapper.toDto(repository.save(entity));
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public CoursDto findById(long id) {
        return coursMapper.toDto(repository.findById(id).orElse(null));
    }

    public Page<CoursDto> findByCondition(CoursDto coursDto, Pageable pageable) {
        Page<Cours> entityPage = repository.findAll(pageable);
        List<Cours> entities = entityPage.getContent();
        return new PageImpl<>(coursMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public CoursDto update(CoursDto coursDto, long id) {
        CoursDto data = findById(id);
        Cours entity = coursMapper.toEntity(coursDto);
        BeanUtils.copyProperties(data, entity);
        return save(coursMapper.toDto(entity));
    }
}