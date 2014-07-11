package com.unigranrio.tcc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nivel {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private int pontos;
	private String CaminhoImagem;

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

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String getCaminhoImagem() {
		return CaminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		CaminhoImagem = caminhoImagem;
	}

}
