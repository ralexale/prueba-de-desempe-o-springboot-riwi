package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.SurveyUpdateRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SurveyRequest extends SurveyUpdateRequest {

    @NotNull(message = "the creatorId field is required")
    @Min(value = 1, message = "Creator id must be greater than 0")
    private Long creatorId;
}
