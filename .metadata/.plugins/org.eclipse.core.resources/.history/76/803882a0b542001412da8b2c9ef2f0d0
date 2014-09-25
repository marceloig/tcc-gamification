package com.unigranrio.tcc.model.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.unigranrio.tcc.model.Alternativa;
import com.unigranrio.tcc.model.ExercicioUmlBean;
import com.unigranrio.tcc.model.ImagemExercicioBean;

@Entity
@NamedQueries({ @NamedQuery(name = "ExercicioUml.findById", query = "SELECT e FROM Exercicio e WHERE e.id = :id"), })
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

	public Map<Alternativa, ImagemExercicioBean> getAlternativasBean() {
		Map<Alternativa, ImagemExercicioBean> alternativasBean = new HashMap<Alternativa, ImagemExercicioBean>();
		
		for (Map.Entry<Alternativa, ImagemExercicio> alternativa : alternativas.entrySet()) {
			ImagemExercicio imgExercicio = alternativa.getValue();		
			ImagemExercicioBean imgExercicioBean = imgExercicio.getImagemExercicioBean();
			
			alternativasBean.put(alternativa.getKey(), imgExercicioBean);
		}
		
		return alternativasBean;
	}

	public ExercicioUmlBean getExercicioUmlBean() {
		ExercicioUmlBean exercicicoUmlBean = new ExercicioUmlBean();
		exercicicoUmlBean.setId(this.getId());
		exercicicoUmlBean.setNome(this.getNome());
		exercicicoUmlBean.setDescricao(this.getDescricao());
		exercicicoUmlBean.setPontos(this.getPontos());
		exercicicoUmlBean.setTentativas(this.getTentativas());
		exercicicoUmlBean.setAssunto(this.getAssunto().getAssuntoBean());
		exercicicoUmlBean.setRespostaUml(respostaUml);
		
		return exercicicoUmlBean;

	}

}
