package com.crudescola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudescola.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
