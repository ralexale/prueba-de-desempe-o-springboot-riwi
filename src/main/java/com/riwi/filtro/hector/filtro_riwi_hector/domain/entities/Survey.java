package com.riwi.filtro.hector.filtro_riwi_hector.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11)")
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "creation_date", columnDefinition = "TIMESTAMP")
    private Timestamp creationDate;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "creator_id")
    private User creatorId;

    @OneToMany(mappedBy = "surveyId", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Question> questions = new HashSet<>();

    private Boolean active;
}
