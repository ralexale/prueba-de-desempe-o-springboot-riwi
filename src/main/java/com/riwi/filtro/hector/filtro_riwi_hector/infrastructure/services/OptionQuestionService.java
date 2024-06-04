package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.services;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.OptionQuestionRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.OptionQuestionUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.OptionQuestion;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.Question;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories.OptionQuestionRepository;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories.QuestionRepository;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services.IOptionQuestionService;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.mappers.OptionQuestionMapper;
import com.riwi.filtro.hector.filtro_riwi_hector.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OptionQuestionService implements IOptionQuestionService {

    @Autowired
    private OptionQuestionRepository optionQuestionRepository;

    @Autowired
    private OptionQuestionMapper optionQuestionMapper;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void createOptionsFromQuestion(List<OptionQuestionRequest> options, Long questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(
                () -> new IdNotFoundException("QUESTION", questionId)
        );


        for (OptionQuestionRequest optionQuestionRequest : options) {
            OptionQuestion optionQuestion = optionQuestionMapper.toOptionQuestion(optionQuestionRequest);
            optionQuestion.setQuestionId(question);
            optionQuestionRepository.save(optionQuestion);
        }
    }

    @Override
    public void updateOptionsFromQuestion(List<OptionQuestionUpdateRequest> optionQuestionRequests, Long questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(
                () -> new IdNotFoundException("QUESTION", questionId)
        );

        for (OptionQuestionUpdateRequest optionQuestionRequest : optionQuestionRequests) {
            OptionQuestion optionQuestion = optionQuestionRepository.findById(optionQuestionRequest.getId())
                    .orElseThrow(() -> new IdNotFoundException("OPTION_QUESTION", optionQuestionRequest.getId()));

            optionQuestion.setQuestionId(question);
            optionQuestionMapper.updateFromOptionQuestionRequest(optionQuestionRequest, optionQuestion);
            optionQuestionRepository.save(optionQuestion);
        }


    }
}
