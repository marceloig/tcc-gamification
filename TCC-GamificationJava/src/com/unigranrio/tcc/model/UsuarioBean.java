package com.unigranrio.tcc.model;

import java.util.List;

import com.unigranrio.tcc.model.entity.Nivel;

public class UsuarioBean {

	private String nome;
	private String login;
	private String senha;
	private Nivel nivel;
	private int pontos;

	private List<ConquistaBean> badges;

	private List<ProgressoBean> progresso;

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

	public List<ConquistaBean> getBadges() {
		return badges;
	}

	public void setBadges(List<ConquistaBean> badges) {
		this.badges = badges;
	}

	public List<ProgressoBean> getProgresso() {
		return progresso;
	}

	public void setProgresso(List<ProgressoBean> progresso) {
		this.progresso = progresso;
	}

}
