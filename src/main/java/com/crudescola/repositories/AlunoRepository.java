package com.crudescola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudescola.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
