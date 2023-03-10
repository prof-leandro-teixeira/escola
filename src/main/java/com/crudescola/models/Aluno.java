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
	private String telefone;
	private String cpf;

	// cria o relacionamento do aluno com a aula
	@OneToMany(mappedBy = "aluno")
	private List<Aula> aulas = new ArrayList<>();

	public Aluno() {
	}
	
	public Aluno(Long id, String nome, String ano) {
		this.id = id;
		this.nome = nome;
		this.ano = ano;
	}
	
	public Aluno(String nome, String ano, String responsavel, String telefone, String cpf) {
		this.nome = nome;
		this.ano = ano;
		this.responsavel = responsavel;
		this.telefone = telefone;
		this.cpf = cpf;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	// get para o relacionamento do aluno com a aula
	public List<Aula> getAulas() {
		return aulas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, cpf, id, nome, responsavel, telefone);
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
		return Objects.equals(ano, other.ano) && Objects.equals(cpf, other.cpf) && id == other.id
				&& Objects.equals(nome, other.nome) && Objects.equals(responsavel, other.responsavel)
				&& Objects.equals(telefone, other.telefone);
	}
}
