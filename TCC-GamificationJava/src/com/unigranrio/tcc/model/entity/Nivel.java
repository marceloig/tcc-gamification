package com.unigranrio.tcc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.unigranrio.tcc.model.NivelBean;

@Entity
@NamedQueries({
		@NamedQuery(name = "Nivel.findByNome", query = "SELECT n FROM Nivel n WHERE n.nome = :nome"),
		@NamedQuery(name = "Nivel.findByProxNivel", query = "SELECT n FROM Nivel n WHERE n.id > :id"), })
public class Nivel {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private int pontos;
	private String nomeImagem;

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

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public NivelBean getNivelBean() {
		NivelBean nivel = new NivelBean();
		nivel.setId(id);
		nivel.setNome(nome);
		nivel.setNomeImagem(nomeImagem);
		nivel.setPontos(pontos);

		return nivel;
	}

}
