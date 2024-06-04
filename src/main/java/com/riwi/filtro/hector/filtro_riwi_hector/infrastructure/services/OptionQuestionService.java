package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.services;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.OptionQuestionRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.OptionQuestionResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.OptionQuestion;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.Question;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories.OptionQuestionRepository;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories.QuestionRepository;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services.IOptionQuestionService;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.mappers.OptionQuestionMapper;
import com.riwi.filtro.hector.filtro_riwi_hector.util.exeptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class OptionQuestionService implements IOptionQuestionService {

    @Autowired
    private OptionQuestionRepository optionQuestionRepository;

    @Autowired
    private OptionQuestionMapper optionQuestionMapper;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public OptionQuestionResponse create(OptionQuestionRequest optionQuestionRequest) {
        OptionQuestion optionQuestion = optionQuestionMapper.toOptionQuestion(optionQuestionRequest);

        Question question = questionRepository.findById(optionQuestionRequest.getQuestionId()).orElseThrow(
                () -> new IdNotFoundException("QUESTION", optionQuestionRequest.getQuestionId())
        );

        optionQuestion.setQuestionId(question);

        optionQuestionRepository.save(optionQuestion);

        return optionQuestionMapper.toOptionQuestionResponse(optionQuestion);


    }

    @Override
    public Page<OptionQuestionResponse> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<OptionQuestionResponse> getById(Long aLong) {
        return Optional.empty();
    }
}
