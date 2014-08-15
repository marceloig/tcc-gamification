package com.unigranrio.tcc.model.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class ExercicioJava extends Exercicio{

	@ElementCollection
	private List<String> exemplosCodigos;
	private String respostaJava;

	public List<String> getExemplosCodigos() {
		return exemplosCodigos;
	}

	public void setExemplosCodigos(List<String> exemplosCodigos) {
		this.exemplosCodigos = exemplosCodigos;
	}

	public String getRespostaJava() {
		return respostaJava;
	}

	public void setRespostaJava(String respostaJava) {
		this.respostaJava = respostaJava;
	}

	
	
}
