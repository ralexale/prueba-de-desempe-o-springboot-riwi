package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OptionQuestionUpdateRequest {

    @NotBlank(message = "the text is required")
    private String text;


    @NotNull(message = "the active field is required")
    private Boolean active;


    @NotNull(message = "Id is required")
    @Min(value = 1, message = "Id must be greater than 0")
    private Long id;
}
