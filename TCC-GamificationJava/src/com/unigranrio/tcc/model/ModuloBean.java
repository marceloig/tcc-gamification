package com.unigranrio.tcc.model;

import java.util.List;

public class ModuloBean {

	private Long id;
	private String nome;
	private List<AssuntoBean> assuntos;
	private List<ProgressoBean> historico;

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

	public List<AssuntoBean> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<AssuntoBean> assuntos) {
		this.assuntos = assuntos;
	}

	public List<ProgressoBean> getHistorico() {
		return historico;
	}

	public void setHistorico(List<ProgressoBean> historico) {
		this.historico = historico;
	}
}
