package com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories;

import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
