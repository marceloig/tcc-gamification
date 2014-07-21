package com.unigranrio.tcc.model.entity;

import javax.persistence.Entity;

@Entity
public class ExercicioJava extends Exercicio{

	private String resposta;

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	
}
