package com.unigranrio.tcc.model.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Exercicio {

	@Id
	private Long id;

	private String nome;
	private String descricao;
	
	@ElementCollection
	private List<String> exemplos;
	
	@ElementCollection
	private List<String> dicas;

	@ManyToOne(optional = false)
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
