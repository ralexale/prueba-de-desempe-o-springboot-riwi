package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.services;


import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.SurveyRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.SurveyUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.SurveyAllResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.SurveyResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.Survey;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.User;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories.SurveyRepository;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories.UserRepository;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services.ISurveyService;

import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.helpers.Email;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.mappers.SurveyMapper;
import com.riwi.filtro.hector.filtro_riwi_hector.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SurveyService implements ISurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private final Email emailHelper;

    @Override
    public SurveyResponse create(SurveyRequest surveyRequest) {
        Survey survey = surveyMapper.toSurvey(surveyRequest);

        User user = userRepository.findById(surveyRequest.getCreatorId())
                .orElseThrow(() -> new IdNotFoundException("USER", surveyRequest.getCreatorId()));
        survey.setCreatorId(user);

        Survey savedSurvey = surveyRepository.save(survey);

        if (Objects.nonNull(user.getEmail()))
            emailHelper.sendEmail(user.getEmail(),
                    "Survey had been create: "+surveyRequest.getTitle(),
                    "Thank you for this new survey", user.getName(), LocalDateTime.now() );

        return surveyMapper.toSurveyResponse(savedSurvey);
    }

    @Override
    public Page<SurveyAllResponse> getAll(Pageable pageable) {
        Page<Survey> surveys = surveyRepository.findAll(pageable);
        return surveys.map(surveyMapper::toSurveyAllResponse);
    }



    @Override
    public Optional<SurveyResponse> getById(Long id) {
        Optional<Survey> survey = surveyRepository.findById(id);
        if (survey.isEmpty()) throw new IdNotFoundException("SURVEY", id);

        return survey.map(surveyMapper::toSurveyResponse);
    }
}
