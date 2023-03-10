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

import com.crudescola.models.Disciplina;
import com.crudescola.repositories.DisciplinaRepository;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	// @PostMapping
	public @ResponseBody Disciplina cadastrarDisciplina(@Valid Disciplina disciplina) {
		disciplinaRepository.save(disciplina);
		return disciplina;
	}

	// evitar uso de findAll para entidades do negócio
	@GetMapping
	public Iterable<Disciplina> retornarDisciplinas() {
		return disciplinaRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Disciplina> retornarDisciplinasPorId(@PathVariable int id) {
		return disciplinaRepository.findById(id);
	}

	@DeleteMapping(path = "/{id}")
	public void excuirDisciplinasPorId(@PathVariable int id) {
		disciplinaRepository.deleteById(id);
	}

	
}
