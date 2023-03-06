package com.crudescola.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String nome;
	private String telefone;
	
	private Disciplina disciplina;
	
	// cria o relacionamento do aluno com a aula
		@OneToMany(mappedBy = "professor")
		private List<Aula> aulas = new ArrayList<>();

	public Professor() {
	}

	public Professor(int id, String nome, Disciplina disciplina, String telefone) {
		this.id = id;
		this.nome = nome;
		this.disciplina = disciplina;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	// get para o relacionamento do aluno com a aula
	public List<Aula> getAulas() {
		return aulas;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(disciplina, id, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return disciplina == other.disciplina && id == other.id && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}
}
