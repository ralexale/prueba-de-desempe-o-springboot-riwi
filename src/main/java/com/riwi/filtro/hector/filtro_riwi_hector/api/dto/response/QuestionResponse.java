package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {

    private Long id;
    private String text;
    private String type;
    private Boolean active;
    private List<OptionQuestionResponse> options;
}
