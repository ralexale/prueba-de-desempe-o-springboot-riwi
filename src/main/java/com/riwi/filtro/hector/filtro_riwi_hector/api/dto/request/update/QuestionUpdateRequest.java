package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionUpdateRequest {
    @NotBlank(message = "the text is required")
    private String text;


    @NotBlank(message = "the type is required")
    @Pattern(regexp = "CLOSED|OPEN", message = "The type must be CLOSED or OPEN.")
    private String type;


    @NotNull(message = "the active field is required")
    private Boolean active;

    @NotNull(message = "the surveyId field is required")
    @Min(value = 1, message = "Survey id must be greater than 0")
    private Long surveyId;

    private List<OptionQuestionUpdateRequest> options;
}
