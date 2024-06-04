package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.SurveyRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.SurveyUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.SurveyResponse;

public interface ISurveyService extends CreateReadDeleteService<SurveyRequest, SurveyResponse, Long>,
        UpdateService<SurveyUpdateRequest, SurveyResponse, Long> {


}
