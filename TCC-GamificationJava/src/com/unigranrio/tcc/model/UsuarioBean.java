package com.unigranrio.tcc.model;

import java.util.ArrayList;

import com.unigranrio.tcc.model.AssuntoBean;
import com.unigranrio.tcc.model.ConquistaBean;
import com.unigranrio.tcc.model.NivelBean;

public class UsuarioBean {
	private String nome;
	private String login;
	private String senha;
	private NivelBean nivel;
	private int pontos;
	private ArrayList<AssuntoBean> assuntos;
	private ArrayList<ConquistaBean> badges;

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

	public ArrayList<AssuntoBean> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(ArrayList<AssuntoBean> assuntos) {
		this.assuntos = assuntos;
	}

	public ArrayList<ConquistaBean> getBadges() {
		return badges;
	}

	public void setBadges(ArrayList<ConquistaBean> badges) {
		this.badges = badges;
	}

}
