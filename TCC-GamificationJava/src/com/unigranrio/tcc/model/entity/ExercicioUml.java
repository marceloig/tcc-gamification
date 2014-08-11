package com.unigranrio.tcc.model.entity;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.unigranrio.tcc.model.Alternativa;

@Entity
public class ExercicioUml extends Exercicio {

	@OneToMany
	private Map<Alternativa, ImagemExercicio> alternativas;

	@Enumerated(EnumType.STRING)
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
