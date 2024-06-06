package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.QuestionRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.QuestionUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.QuestionUpdateWithoutOptions;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.QuestionResponse;

public interface IQuestionService extends CreateReadService<QuestionRequest, QuestionResponse, Long>,
        UpdateService<QuestionUpdateRequest, QuestionResponse, Long> {

    void delete(Long id);

    QuestionResponse updateQuestionRequest(
            QuestionUpdateWithoutOptions questionRequest,
            Long id
    );
}
