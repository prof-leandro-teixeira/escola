package com.crudescola.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sobreController {

	@RequestMapping( "/sobre")
	public String sobre() {
		return "Seja bem vindo ao sistema de controle de aulas!";
	}

}
