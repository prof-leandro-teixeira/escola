package com.crudescola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudescola.models.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

}
