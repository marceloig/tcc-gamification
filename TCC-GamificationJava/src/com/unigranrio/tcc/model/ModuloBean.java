package com.unigranrio.tcc.model;

import java.util.List;

import com.unigranrio.tcc.model.entity.Assunto;
import com.unigranrio.tcc.model.entity.Progresso;

public class ModuloBean {

	private Long id;
	private String nome;
	private List<Assunto> assuntos;
	private List<Progresso> historico;

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

	public List<Assunto> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<Assunto> assuntos) {
		this.assuntos = assuntos;
	}

	public List<Progresso> getHistorico() {
		return historico;
	}

	public void setHistorico(List<Progresso> historico) {
		this.historico = historico;
	}
}
