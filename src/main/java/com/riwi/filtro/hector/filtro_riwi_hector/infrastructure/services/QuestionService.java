package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.services;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.QuestionRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.QuestionUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.QuestionResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.Question;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.Survey;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories.QuestionRepository;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories.SurveyRepository;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services.IQuestionService;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.mappers.QuestionMapper;
import com.riwi.filtro.hector.filtro_riwi_hector.util.exeptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class QuestionService implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    @Autowired
    private QuestionMapper questionMapper;


    @Autowired
    private SurveyRepository surveyRepository;


    @Override
    public QuestionResponse create(QuestionRequest questionRequest) {
        Question question = questionMapper.toQuestion(questionRequest);

        Survey survey = surveyRepository.findById(questionRequest.getSurveyId()).orElseThrow(() ->
                new IdNotFoundException("survey", questionRequest.getSurveyId()));

        question.setSurveyId(survey);
        questionRepository.save(question);

        return questionMapper.toQuestionResponse(question);
    }

    @Override
    public Page<QuestionResponse> getAll(Pageable pageable) {
        Page<Question> questions = questionRepository.findAll(pageable);
        return questions.map(questionMapper::toQuestionResponse);
    }

    @Override
    public Optional<QuestionResponse> getById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        return question.map(questionMapper::toQuestionResponse);
    }

    @Override
    public QuestionResponse update(QuestionUpdateRequest questionUpdateRequest, Long id) {
       Question existingQuestion = questionRepository.findById(id).orElseThrow(() ->
               new IdNotFoundException("question", id));

       questionMapper.updateFromQuestionRequest(questionUpdateRequest, existingQuestion);
       questionRepository.save(existingQuestion);
       return questionMapper.toQuestionResponse(existingQuestion);
    }
}
