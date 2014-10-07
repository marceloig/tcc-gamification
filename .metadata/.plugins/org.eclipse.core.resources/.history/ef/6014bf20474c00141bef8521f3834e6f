package com.unigranrio.tcc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.unigranrio.tcc.model.ProgressoBean;


@Entity
@NamedQueries({ @NamedQuery(name = "Progresso.findByUsuario", query = "SELECT p FROM Progresso p WHERE p.usuario = :usuario ORDER BY p.id DESC" ), })
public class Progresso {
	
	@Id 
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Exercicio exercicio;
	
	private float porcentagem;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public float getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(float porcentagem) {
		this.porcentagem = porcentagem;
	}

	public ProgressoBean getProgressoBean(){
		ProgressoBean progressoBean = new ProgressoBean();
		progressoBean.setId(id);
		progressoBean.setExercicio(exercicio.getExercicioBean());
		progressoBean.setPorcentagem(porcentagem);
		return progressoBean;
	}
	
}
