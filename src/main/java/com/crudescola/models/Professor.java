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
	private Long id;
	@NotBlank
	private String nome;
	private String telefone;
	
	// cria o relacionamento do aluno com a aula
		@OneToMany(mappedBy = "professor")
		private List<Aula> aulas = new ArrayList<>();

	public Professor() {
	}
	
	public Professor(Long id, String nome, String telefone) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	

	public Professor(@NotBlank String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
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

	
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, telefone);
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
		return id == other.id && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}
}
