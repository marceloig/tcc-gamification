package com.unigranrio.tcc.model.entity;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.unigranrio.tcc.model.Alternativa;

@Entity
@NamedQueries ({
@NamedQuery(name = "ExercicioUml.findById", query = "SELECT e FROM Exercicio e WHERE e.id = :id"),
})
public class ExercicioUml extends Exercicio {

	
	@OneToMany
	private Map<Alternativa, ImagemExercicio> alternativas;

	@Enumerated(EnumType.STRING)
	private Alternativa respostaUml;

	public Map<Alternativa, ImagemExercicio> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(Map<Alternativa, ImagemExercicio> alternativas) {
		this.alternativas = alternativas;
	}

	public Alternativa getRespostaUml() {
		return respostaUml;
	}

	public void setRespostaUml(Alternativa respostaUml) {
		this.respostaUml = respostaUml;
	}

	

}
