package com.unigranrio.tcc.model;

import java.util.List;

public class UsuarioBean {

	private String nome;
	private String login;
	private String senha;
	private NivelBean nivel;
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

	public NivelBean getNivel() {
		return nivel;
	}

	public void setNivel(NivelBean nivel) {
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
