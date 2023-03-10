package com.crudescola.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	private String ano;
	private String responsavel;

	// cria o relacionamento do aluno com a aula
	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	private List<Aula> aulas = new ArrayList<>();

	public Aluno() {
	}

	public Aluno(Long id, String nome, String ano, String responsavel) {
		this.id = id;
		this.nome = nome;
		this.ano = ano;
		this.responsavel = responsavel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	// get para o relacionamento do aluno com a aula
	public List<Aula> getAulas() {
		return aulas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, id, nome, responsavel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(ano, other.ano) && id == other.id && Objects.equals(nome, other.nome)
				&& Objects.equals(responsavel, other.responsavel);
	}
}
