package com.unigranrio.tcc.model;

public class ImagemExercicioBean {

	private Long id;
	private String caminhoImagem;
	private String nomeImagem;

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}
}
