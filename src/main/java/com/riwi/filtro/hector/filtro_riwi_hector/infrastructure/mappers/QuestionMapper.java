package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.mappers;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.QuestionRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.QuestionUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.QuestionUpdateWithoutOptions;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.QuestionResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {OptionQuestionMapper.class})
public interface QuestionMapper {



    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "options", ignore = true),
            @Mapping(source = "surveyId", target = "surveyId.id")
    })
    Question toQuestion(QuestionRequest questionRequest);

    @Mapping(source = "options", target = "options")
    QuestionResponse toQuestionResponse(Question question);



    @Mappings({
            @Mapping(target = "options", ignore = true),
            @Mapping(target = "surveyId.id", source = "surveyId"),
    })
    void updateFromQuestionRequest(QuestionUpdateRequest questionRequest, @MappingTarget Question question);

    @Mapping(target = "surveyId.id", source = "surveyId")
    void updateQuestionRequest(QuestionUpdateWithoutOptions questionRequest, @MappingTarget Question question);
}
