package com.crudescola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crudescola.models.Aula;

public interface AulaRepository extends JpaRepository<Aula, Integer> {
}
