package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.mappers;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.SurveyRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.SurveyUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.SurveyAllResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.SurveyResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.Survey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {QuestionMapper.class})
public interface SurveyMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "creatorId", target = "creatorId.id")
    })
    Survey toSurvey(SurveyRequest surveyRequest);

    @Mapping(source = "questions", target = "questions")
    SurveyResponse toSurveyResponse(Survey survey);


    SurveyAllResponse toSurveyAllResponse(Survey survey);



    void updateFromSurveyRequest(SurveyUpdateRequest surveyUpdateRequest, @MappingTarget Survey survey);
}
