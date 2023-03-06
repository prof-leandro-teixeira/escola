package com.crudescola.models;

public enum Disciplina{
	MATEMÁTICA(1),
	PORTUGUÊS(2),
	CIÊNCIAS(3),
	HIST_GEO(4);
	
	private int id;
	
	private Disciplina(int id) {
		this.id = id;
	}
	
	public int getId() {
	return id;
	}
	
	public static Disciplina valueOf(int id) {
		for(Disciplina value : Disciplina.values()) {
			if(value.getId() == id) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido para disciplina.");
	}
	
}