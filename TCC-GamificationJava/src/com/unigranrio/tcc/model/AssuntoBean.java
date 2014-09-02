package com.unigranrio.tcc.model;

import java.util.List;

import com.unigranrio.tcc.model.entity.Modulo;

public class AssuntoBean {

	private Long id;
	private String nome;
	private ModuloBean modulo;
	private List<ExercicioBean> exercicios;
	private List<ConquistaBean> conquistas;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ModuloBean getModulo() {
		return modulo;
	}
	public void setModulo(ModuloBean modulo) {
		this.modulo = modulo;
	}
	public List<ExercicioBean> getExercicios() {
		return exercicios;
	}
	public void setExercicios(List<ExercicioBean> exercicios) {
		this.exercicios = exercicios;
	}
	public List<ConquistaBean> getConquistas() {
		return conquistas;
	}
	public void setConquistas(List<ConquistaBean> conquistas) {
		this.conquistas = conquistas;
	}
	
}
