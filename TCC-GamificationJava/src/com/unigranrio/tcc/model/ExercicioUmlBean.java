package com.unigranrio.tcc.model;

import java.util.List;

public class ExercicioUmlBean {
	
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
