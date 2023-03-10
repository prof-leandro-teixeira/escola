package com.crudescola.controllers;

import com.crudescola.models.Aluno;
import com.crudescola.models.Aula;
import com.crudescola.models.Disciplina;
import com.crudescola.models.Professor;

public class TesteController {
	
	public static void main(String[] args) {
		
		Aluno a = new Aluno(1L, "joão","8");
		Professor p = new Professor(1L, "LEANDRO", "000-0000");
		Disciplina d = new Disciplina(1L,"Matemática");
		
		Aula au = new Aula(1L, a, p, d);
	
		System.out.println("Código da aula: "+ au.getId()
							+"\nAluno: " + a.getNome()
							+ "\nProfessor: " + p.getNome()
							+ "\nDisciplina: " + d.getNome());
	}
}
