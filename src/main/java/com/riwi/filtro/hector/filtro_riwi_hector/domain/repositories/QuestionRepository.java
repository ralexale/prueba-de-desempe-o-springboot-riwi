package com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories;

import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
