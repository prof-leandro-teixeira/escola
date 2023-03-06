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

import com.crudescola.models.Aula;
import com.crudescola.repositories.AulaRepository;

@RestController
@RequestMapping("/aulas")
public class AulaController {

	@Autowired
	private AulaRepository aulaRepository;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	// @PostMapping
	public @ResponseBody Aula cadastrarAulas(@Valid Aula aula) {
		aulaRepository.save(aula);
		return aula;
	}


	@GetMapping(path = "/{id}")
	public Optional<Aula> retornarAulasPorId(@PathVariable int id) {
		return aulaRepository.findById(id);
	}

	@DeleteMapping(path = "/{id}")
	public void excuirAulassorId(@PathVariable int id) {
		aulaRepository.deleteById(id);
	}

}
