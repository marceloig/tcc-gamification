package com.unigranrio.tcc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.unigranrio.tcc.model.BadgeBean;

@Entity
public class Badge {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private String descricao;
	private String nomeImagem;

	@OneToOne(mappedBy = "badge")
	private Conquista conquista;

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

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public Conquista getConquista() {
		return conquista;
	}

	public void setConquista(Conquista conquista) {
		this.conquista = conquista;
	}

	public BadgeBean getBadgeBean() {
		BadgeBean badgeBean = new BadgeBean();
		badgeBean.setId(id);
		badgeBean.setNome(nome);
		badgeBean.setDescricao(descricao);
		badgeBean.setNomeImagem(nomeImagem);
		return badgeBean;
	}

}
