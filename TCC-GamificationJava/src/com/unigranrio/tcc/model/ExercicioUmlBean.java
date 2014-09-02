package com.unigranrio.tcc.model;

import java.util.Map;

import com.unigranrio.tcc.model.entity.ImagemExercicio;

public class ExercicioUmlBean extends ExercicioBean{

	private Map<Alternativa, ImagemExercicioBean> alternativas;
	private Alternativa respostaUml;

	public Map<Alternativa, ImagemExercicioBean> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(Map<Alternativa, ImagemExercicioBean> alternativas) {
		this.alternativas = alternativas;
	}

	public Alternativa getRespostaUml() {
		return respostaUml;
	}

	public void setRespostaUml(Alternativa respostaUml) {
		this.respostaUml = respostaUml;
	}


}
