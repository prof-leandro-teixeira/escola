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

import com.crudescola.models.Aluno;
import com.crudescola.repositories.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	// @PostMapping
	public @ResponseBody Aluno cadastrarAluno(@Valid Aluno aluno) {
		alunoRepository.save(aluno);
		return aluno;
	}

	// evitar uso de findAll para entidades do negócio
	@GetMapping
	public Iterable<Aluno> retornarAlunos() {
		return alunoRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Aluno> retornarAlunosPorId(@PathVariable int id) {
		return alunoRepository.findById(id);
	}

	@DeleteMapping(path = "/{id}")
	public void excuirAlunosPorId(@PathVariable int id) {
		alunoRepository.deleteById(id);
	}

	// RequestMapping substitui a necessidade de implementar um metodo inteiro para
	// alterar
//	@PutMapping
//	public @ResponseBody Aluno alterarAluno(@Valid Aluno aluno) {
//		alunoRepository.save(aluno);
//		return aluno;
//	}
}
