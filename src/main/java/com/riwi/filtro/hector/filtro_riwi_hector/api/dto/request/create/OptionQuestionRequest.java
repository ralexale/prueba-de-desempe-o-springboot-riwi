package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create;


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
public class OptionQuestionRequest {


    @NotBlank(message = "the text is required")
    private String text;


    @NotNull(message = "the active field is required")
    private Boolean active;

}
