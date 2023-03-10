package com.crudescola.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aula implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date timestamp;
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professor professor;
	@ManyToOne
	@JoinColumn(name="disciplina_id")
	private Disciplina disciplina;
		
	public Aula() {
	}

	public Aula(Long id, Date timestamp, Aluno aluno, Professor professor, Disciplina disciplina) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.aluno = aluno;
		this.professor = professor;
		this.disciplina = disciplina;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, timestamp, disciplina, id, professor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(timestamp, other.timestamp) && disciplina == other.disciplina
				&& id == other.id && Objects.equals(professor, other.professor);
	}

}
