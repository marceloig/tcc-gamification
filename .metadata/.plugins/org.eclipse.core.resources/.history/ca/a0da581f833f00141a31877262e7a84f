package com.unigranrio.tcc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.unigranrio.tcc.model.ProgressoBean;


@Entity
public class Progresso {
	
	@Id 
	@GeneratedValue
	private Long id;
	
	@ManyToOne(optional = false)
	private Usuario usuario;
	
	@ManyToOne(optional = false)
	private Modulo modulo;
	
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

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	
	public ProgressoBean getProgressoBean(){
		ProgressoBean progressoBean = new ProgressoBean();
		progressoBean.setId(id);
		progressoBean.setModulo(modulo.getModuloBean());
		
		return progressoBean;
	}
	
}
