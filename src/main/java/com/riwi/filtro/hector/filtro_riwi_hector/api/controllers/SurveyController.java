package com.riwi.filtro.hector.filtro_riwi_hector.api.controllers;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.SurveyRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.SurveyAllResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.SurveyResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services.ISurveyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/surveys")
@AllArgsConstructor
public class SurveyController {

    @Autowired
    private ISurveyService surveyService;


    @PostMapping
    public ResponseEntity<SurveyResponse> createSurvey(@Validated @RequestBody SurveyRequest surveyRequest) {

        return ResponseEntity.ok(surveyService.create(surveyRequest));
    }


    @GetMapping
    public ResponseEntity<Page<SurveyAllResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size){

        Pageable pageable = PageRequest.of(page, size);
        if (page != 0) pageable = PageRequest.of(page - 1, size);

        return ResponseEntity.ok(surveyService.getAll(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<SurveyResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(surveyService.getById(id));
    }
}
