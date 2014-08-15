package com.unigranrio.tcc.model;

import com.unigranrio.tcc.model.entity.Modulo;
import com.unigranrio.tcc.model.entity.Usuario;

public class ProgressoBean {
	
	private Long id;
	private Usuario usuario;
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
	
}
