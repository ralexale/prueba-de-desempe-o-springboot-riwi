package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SurveyAllResponse {

    private Long id;
    private String title;
    private String description;
    private Boolean active;
    private LocalDateTime creationDate;
}
