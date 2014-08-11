package com.unigranrio.tcc.model;

import java.util.Map;

import com.unigranrio.tcc.model.entity.ImagemExercicio;

public class ExercicioUmlBean extends ExercicioBean{

	private Map<Alternativa, ImagemExercicio> alternativas;
	private Alternativa resposta;

	public Map<Alternativa, ImagemExercicio> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(Map<Alternativa, ImagemExercicio> alternativas) {
		this.alternativas = alternativas;
	}

	public Alternativa getResposta() {
		return resposta;
	}

	public void setResposta(Alternativa resposta) {
		this.resposta = resposta;
	}

}
