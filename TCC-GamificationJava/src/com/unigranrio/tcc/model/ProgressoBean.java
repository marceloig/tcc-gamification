package com.unigranrio.tcc.model;


public class ProgressoBean {
	
	private Long id;
	private UsuarioBean usuario;
	private ExercicioBean exercicio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public ExercicioBean getExercicio() {
		return exercicio;
	}

	public void setExercicio(ExercicioBean exercicio) {
		this.exercicio = exercicio;
	}

	
	
}
