package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class QuestionUpdateRequest {
    @NotBlank(message = "the text is required")
    private String text;


    @NotBlank(message = "the type is required")
    @Size(
            max = 50,
            message = "the type must be less than 50 characters"
    )
    private String type;

    @NotNull(message = "the active field is required")
    private Boolean active;
}
