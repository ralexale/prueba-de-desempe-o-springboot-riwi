package com.riwi.filtro.hector.filtro_riwi_hector.api.controllers;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.QuestionRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.QuestionUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.QuestionUpdateWithoutOptions;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.QuestionResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services.IQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {
    @Autowired
    private IQuestionService questionService;


    @PostMapping
    public ResponseEntity<QuestionResponse> createQuestion(@Validated @RequestBody QuestionRequest questionRequest) {
        return ResponseEntity.ok(questionService.create(questionRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<QuestionResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size){

        Pageable pageable = PageRequest.of(page, size);
        if (page != 0) pageable = PageRequest.of(page - 1, size);

        return ResponseEntity.ok(questionService.getAll(pageable));
    }

    @PutMapping("/{id}/options")
    public ResponseEntity<QuestionResponse> updateQuestion(@PathVariable Long id, @Validated @RequestBody QuestionUpdateRequest questionRequest) {
        return ResponseEntity.ok(questionService.update(questionRequest, id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<QuestionResponse> updateQuestionWithoutOptions(@PathVariable Long id, @Validated @RequestBody QuestionUpdateWithoutOptions questionRequest) {
        return ResponseEntity.ok(questionService.updateQuestionRequest(questionRequest, id));
    }


}
