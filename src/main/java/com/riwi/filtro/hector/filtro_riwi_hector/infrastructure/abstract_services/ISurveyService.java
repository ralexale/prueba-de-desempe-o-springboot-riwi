package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.SurveyRequest;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.SurveyAllResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.SurveyResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ISurveyService{

    SurveyResponse create(SurveyRequest surveyRequest);

    Page<SurveyAllResponse> getAll(Pageable pageable);

    Optional<SurveyResponse> getById(Long id);
}
