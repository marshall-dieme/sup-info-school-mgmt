package com.supinfo.formation.repository;

import com.supinfo.formation.model.FicheFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FicheFormationRepository extends JpaRepository<FicheFormation, String> {
}