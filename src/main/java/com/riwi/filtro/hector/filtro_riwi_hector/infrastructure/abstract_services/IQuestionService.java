package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.QuestionRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.QuestionUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.QuestionResponse;

public interface IQuestionService extends CreateReadDeleteService<QuestionRequest, QuestionResponse, Long>,
        UpdateService<QuestionUpdateRequest, QuestionResponse, Long> {
}
