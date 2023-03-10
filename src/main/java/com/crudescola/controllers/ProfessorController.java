package com.crudescola.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudescola.models.Professor;
import com.crudescola.repositories.ProfessorRepository;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	// @PostMapping
	public @ResponseBody Professor cadastrarProfessor(@Valid Professor professor) {
		professorRepository.save(professor);
		return professor;
	}

	@GetMapping
	public Iterable<Professor> retornarProfessores() {
		return professorRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Professor> retornarProfessorPorId(@PathVariable int id) {
		return professorRepository.findById(id);
	}

	@DeleteMapping(path = "/{id}")
	public void excuirProfessorPorId(@PathVariable int id) {
		professorRepository.deleteById(id);
	}
}