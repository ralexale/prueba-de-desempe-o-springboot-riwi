package com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories;

import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
