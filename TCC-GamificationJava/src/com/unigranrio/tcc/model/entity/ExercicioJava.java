package com.unigranrio.tcc.model.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.unigranrio.tcc.model.ExercicioJavaBean;

@Entity
@NamedQueries({ @NamedQuery(name = "ExercicioJava.findById", query = "SELECT e FROM Exercicio e LEFT JOIN FETCH e.dicas WHERE e.id = :id"), })
public class ExercicioJava extends Exercicio{

	@ElementCollection
	private List<String> exemplosCodigos;
	private String codigoReferencia;
	private String respostaJava;

	public List<String> getExemplosCodigos() {
		return exemplosCodigos;
	}

	public void setExemplosCodigos(List<String> exemplosCodigos) {
		this.exemplosCodigos = exemplosCodigos;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	public String getRespostaJava() {
		return respostaJava;
	}

	public void setRespostaJava(String respostaJava) {
		this.respostaJava = respostaJava;
	}

	public ExercicioJavaBean getExercicioJavaBean(){
		ExercicioJavaBean exercicioJavaBean = new ExercicioJavaBean();
		
		exercicioJavaBean.setId(this.getId());
		exercicioJavaBean.setNome(this.getNome());
		exercicioJavaBean.setDescricao(this.getDescricao());
		exercicioJavaBean.setDicas(this.getDicas());
		exercicioJavaBean.setTentativas(this.getTentativas());
		exercicioJavaBean.setPontos(this.getPontos());
		exercicioJavaBean.setAssunto(this.getAssunto().getAssuntoBean());
		exercicioJavaBean.setCodigoReferencia(codigoReferencia);
		exercicioJavaBean.setRespostaJava(respostaJava);
		
		return exercicioJavaBean;
	}
	
}
