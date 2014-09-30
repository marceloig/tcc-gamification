package com.unigranrio.tcc.model;

import java.util.List;

public class ExercicioBean {

	private Long id;
	private String nome;
	private String descricao;
	private int tentativas;
	private int pontos;
	private List<String> dicas;
	private AssuntoBean assunto;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getTentativas() {
		return tentativas;
	}

	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public List<String> getDicas() {
		return dicas;
	}

	public void setDicas(List<String> dicas) {
		this.dicas = dicas;
	}

	public AssuntoBean getAssunto() {
		return assunto;
	}

	public void setAssunto(AssuntoBean assunto) {
		this.assunto = assunto;
	}

	public List<ProgressoBean> getHistorico() {
		return historico;
	}

	public void setHistorico(List<ProgressoBean> historico) {
		this.historico = historico;
	}
	
	
}
