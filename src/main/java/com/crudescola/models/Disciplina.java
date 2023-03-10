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
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	
	// cria o relacionamento do aluno com a aula
	@JsonIgnore
	@OneToMany(mappedBy = "disciplina")
	private List<Aula> aulas = new ArrayList<>();
		

	public Disciplina() {
	}
	
	public Disciplina(Long id, @NotBlank String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(aulas, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(aulas, other.aulas) && id == other.id && Objects.equals(nome, other.nome);
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

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	// get para o relacionamento do aluno com a aula
	public List<Aula> getAulas() {
		return aulas;
	}
}
