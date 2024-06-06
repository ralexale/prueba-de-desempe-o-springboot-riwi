package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update;



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

public class SurveyUpdateRequest {

    @NotBlank(message = "the title is required")
    private String title;


    @NotBlank(message = "the description is required")
    private String description;

    @NotNull(message = "the active field is required")
    private Boolean active;

}
