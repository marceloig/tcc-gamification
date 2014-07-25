package com.unigranrio.tcc.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
		@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
		@NamedQuery(name = "Usuario.findMaiorEIgual", query = "SELECT u FROM Usuario u WHERE u.pontos >= :pontos "
				+ "ORDER BY u.pontos ASC"),
		@NamedQuery(name = "Usuario.findMenor", query = "SELECT u FROM Usuario u WHERE u.pontos < :pontos "
				+ "ORDER BY u.pontos DESC"),
		@NamedQuery(name = "Usuario.listByPontuacao", query = "SELECT u FROM Usuario u "
				+ "ORDER BY u.pontos DESC"),
		
		})
public class Usuario {

	@Column(nullable = false)
	private String nome;

	@Id
	private String login;

	@Column(nullable = false)
	private String senha;

	@ManyToOne(optional = false)
	private Nivel nivel;

	@Column(nullable = false)
	private int pontos;

	@OneToMany
	private List<Conquista> badges;

	@OneToMany
	private List<Progresso> progresso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public List<Conquista> getBadges() {
		return badges;
	}

	public void setBadges(List<Conquista> badges) {
		this.badges = badges;
	}

	public List<Progresso> getProgresso() {
		return progresso;
	}

	public void setProgresso(List<Progresso> progresso) {
		this.progresso = progresso;
	}

}
