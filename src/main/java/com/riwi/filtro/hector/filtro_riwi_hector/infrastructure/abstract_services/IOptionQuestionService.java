package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.OptionQuestionRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.OptionQuestionUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.OptionQuestionResponse;

public interface IOptionQuestionService extends CreateReadDeleteService<OptionQuestionRequest, OptionQuestionResponse, Long>,
        UpdateService<OptionQuestionUpdateRequest, OptionQuestionResponse, Long> {
}
