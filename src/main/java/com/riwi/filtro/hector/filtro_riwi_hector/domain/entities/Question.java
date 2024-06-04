package com.riwi.filtro.hector.filtro_riwi_hector.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11)")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(length = 50)
    private String type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "survey_id")
    private Survey surveyId;


    @OneToMany(mappedBy = "questionId", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<OptionQuestion> optionQuestions = new HashSet<>();


    private Boolean active;

}
