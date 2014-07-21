package com.unigranrio.tcc.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Modulo {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@OneToMany
	private List<Assunto> assuntos;
	
	@OneToMany
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
