package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OptionQuestionResponse {

    private Long id;
    private String text;
    private Boolean active;
}
