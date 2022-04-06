package com.supinfo.formation.repository;

import com.supinfo.formation.model.DetailPrestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailPrestationRepository extends JpaRepository<DetailPrestation, Long> {
}