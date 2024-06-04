package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.QuestionUpdateRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class QuestionRequest extends QuestionUpdateRequest {

    @NotNull(message = "the surveyId field is required")
    @Min(value = 1, message = "Survey id must be greater than 0")
    private Long surveyId;
}
