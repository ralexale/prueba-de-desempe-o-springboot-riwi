package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.OptionQuestionUpdateRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OptionQuestionRequest extends OptionQuestionUpdateRequest {


    @NotNull(message = "the questionId field is required")
    @Min(value = 1, message = "the questionId field must be greater than 0")
    private Long questionId;
}
