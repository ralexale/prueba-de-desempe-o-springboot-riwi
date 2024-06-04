package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.mappers;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.OptionQuestionRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.OptionQuestionResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.OptionQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OptionQuestionMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "questionId", source = "questionId.id")
    })
    OptionQuestion toOptionQuestion(OptionQuestionRequest optionQuestionRequest);


    OptionQuestionResponse toOptionQuestionResponse(OptionQuestion optionQuestion);
}
