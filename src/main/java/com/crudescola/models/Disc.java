package com.crudescola.models;

public enum Disc{
	MATEMÁTICA(1),
	PORTUGUÊS(2),
	CIÊNCIAS(3),
	HIST_GEO(4);
	
	private int id;
	
	private Disc(int id) {
		this.id = id;
	}
	
	public int getId() {
	return id;
	}
	
	public static Disc valueOf(int id) {
		for(Disc value : Disc.values()) {
			if(value.getId() == id) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido para disciplina.");
	}
	
}