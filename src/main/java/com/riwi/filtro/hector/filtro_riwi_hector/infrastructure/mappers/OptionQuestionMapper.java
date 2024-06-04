package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.mappers;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.OptionQuestionRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.OptionQuestionUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.OptionQuestionResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.OptionQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OptionQuestionMapper {


            @Mapping(target = "id", ignore = true)
    OptionQuestion toOptionQuestion(OptionQuestionRequest optionQuestionRequest);


    OptionQuestionResponse toOptionQuestionResponse(OptionQuestion optionQuestion);


    void updateFromOptionQuestionRequest(OptionQuestionUpdateRequest optionQuestionRequest, @MappingTarget OptionQuestion optionQuestion);
}
