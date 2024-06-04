package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.services;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.QuestionRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.QuestionUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.QuestionUpdateWithoutOptions;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.QuestionResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.Question;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.Survey;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories.OptionQuestionRepository;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories.QuestionRepository;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories.SurveyRepository;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services.IOptionQuestionService;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services.IQuestionService;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.mappers.QuestionMapper;
import com.riwi.filtro.hector.filtro_riwi_hector.util.enums.QuestionType;
import com.riwi.filtro.hector.filtro_riwi_hector.util.exeptions.IdNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class QuestionService implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    @Autowired
    private QuestionMapper questionMapper;


    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private OptionQuestionRepository optionQuestionRepository;

    @Autowired
    private final IOptionQuestionService optionQuestionService;


    @Override
    public QuestionResponse create(QuestionRequest questionRequest) {
        Question question = questionMapper.toQuestion(questionRequest);
        Survey survey = surveyRepository.findById(questionRequest.getSurveyId()).orElseThrow(() ->
                new IdNotFoundException("survey", questionRequest.getSurveyId()));



        question.setSurveyId(survey);
        Question savedQuestion = questionRepository.save(question);

        if (QuestionType.CLOSED == QuestionType.valueOf(questionRequest.getType())) {
            if (questionRequest.getOptions() != null)
                optionQuestionService.createOptionsFromQuestion(questionRequest.getOptions(), savedQuestion.getId());
            else throw new RuntimeException("the options are empty, change the type if you don't need options");
        }

        return questionMapper.toQuestionResponse(savedQuestion);
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
               new IdNotFoundException("QUESTION", id));

        Survey existingSurvey = surveyRepository.findById(questionUpdateRequest.getSurveyId())
                .orElseThrow(() -> new IdNotFoundException("SURVEY", questionUpdateRequest.getSurveyId()));
        existingQuestion.setSurveyId(existingSurvey);


        questionMapper.updateFromQuestionRequest(questionUpdateRequest, existingQuestion);

        Question updatedQuestion = questionRepository.save(existingQuestion);

        if (QuestionType.CLOSED == QuestionType.valueOf(questionUpdateRequest.getType())) {
            if (questionUpdateRequest.getOptions() != null)
                optionQuestionService.updateOptionsFromQuestion(questionUpdateRequest.getOptions(), updatedQuestion.getId());
            else throw new RuntimeException("the options are empty, change the type if you don't need options");
        }


       return questionMapper.toQuestionResponse(updatedQuestion);
    }

    @Override
    public void delete(Long id) {
        System.out.println("holaaaaaaaaaaaaaaaaaaaa");

        Question question = questionRepository.findById(id).orElseThrow(() ->
                new IdNotFoundException("QUESTION", id));
        System.out.println(id);

        questionRepository.deleteById(id);
    }


    @Override
    public QuestionResponse updateQuestionRequest(QuestionUpdateWithoutOptions questionRequest, Long id) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("QUESTION", id));

        Survey existingSurvey = surveyRepository.findById(questionRequest.getSurveyId())
                .orElseThrow(() -> new IdNotFoundException("SURVEY", questionRequest.getSurveyId()));
        existingQuestion.setSurveyId(existingSurvey);


        questionMapper.updateQuestionRequest(questionRequest, existingQuestion);
        Question updateQuestion = questionRepository.save(existingQuestion);

        return questionMapper.toQuestionResponse(updateQuestion);
    }
}
