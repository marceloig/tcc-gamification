package com.unigranrio.tcc.model;


public class BadgeBean {
	
	private Long id;
	private String nome;
	private String descricao;
	private String nomeImagem;
	private ConquistaBean conquista;

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

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public ConquistaBean getConquista() {
		return conquista;
	}

	public void setConquista(ConquistaBean conquista) {
		this.conquista = conquista;
	}

}
