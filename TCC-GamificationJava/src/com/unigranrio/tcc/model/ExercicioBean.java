package com.unigranrio.tcc.model;

import java.util.List;

import com.unigranrio.tcc.model.entity.Assunto;

public class ExercicioBean {

	private Long id;
	private String nome;
	private String descricao;
	private List<String> exemplos;
	private List<String> dicas;
	private Assunto assunto;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<String> getExemplos() {
		return exemplos;
	}

	public void setExemplos(List<String> exemplos) {
		this.exemplos = exemplos;
	}

	public List<String> getDicas() {
		return dicas;
	}

	public void setDicas(List<String> dicas) {
		this.dicas = dicas;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

}
