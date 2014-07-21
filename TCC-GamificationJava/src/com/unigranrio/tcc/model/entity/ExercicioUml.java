package com.unigranrio.tcc.model.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class ExercicioUml extends Exercicio {

	@ElementCollection
	private List<String> opcaoResposta;
	private String resposta;

	public List<String> getOpcaoResposta() {
		return opcaoResposta;
	}

	public void setOpcaoResposta(List<String> opcaoResposta) {
		this.opcaoResposta = opcaoResposta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

}
