package com.unigranrio.tcc.model;

import java.util.List;

import com.unigranrio.tcc.model.entity.Conquista;
import com.unigranrio.tcc.model.entity.Nivel;
import com.unigranrio.tcc.model.entity.Progresso;

public class UsuarioBean {

	private String nome;
	private String login;
	private String senha;
	private Nivel nivel;
	private int pontos;

	private List<Conquista> badges;

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
