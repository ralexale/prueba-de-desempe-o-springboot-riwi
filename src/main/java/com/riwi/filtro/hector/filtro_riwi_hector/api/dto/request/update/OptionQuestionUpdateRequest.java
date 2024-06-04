package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OptionQuestionUpdateRequest {

    @NotBlank(message = "the text is required")
    private String text;
    @NotNull(message = "the active field is required")
    private Boolean active;
}
