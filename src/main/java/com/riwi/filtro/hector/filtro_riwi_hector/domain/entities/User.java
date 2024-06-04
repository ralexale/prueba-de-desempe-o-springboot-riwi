package com.riwi.filtro.hector.filtro_riwi_hector.domain.entities;

import com.riwi.filtro.hector.filtro_riwi_hector.util.enums.Role;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11)")
    private Long id;

    @Column(length = 100)
    private String email;

    @Column(name = "full_name", length = 100)
    private String name;

    private String password;


    private Boolean active;

    @OneToMany(mappedBy = "creatorId", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Survey> surveys = new HashSet<>();
}
