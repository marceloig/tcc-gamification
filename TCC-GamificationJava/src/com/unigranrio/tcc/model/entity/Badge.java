package com.unigranrio.tcc.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unigranrio.tcc.model.BadgeBean;
import com.unigranrio.tcc.model.ConquistaBean;

@Entity
public class Badge {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private String descricao;
	private String nomeImagem;

	@OneToMany
	private List<Conquista> conquistas;

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

	public List<Conquista> getConquistas() {
		return conquistas;
	}

	public void setConquistas(List<Conquista> conquistas) {
		this.conquistas = conquistas;
	}
	
	public List<ConquistaBean> getConquistasBean(){
		List<ConquistaBean> conquistasBean = new ArrayList<ConquistaBean>();
		for(Conquista conquista : conquistas){
			ConquistaBean conquistaBean = new ConquistaBean();
			
			conquistaBean.setId(conquista.getId());
			conquistaBean.setNumeroDeBadges(conquista.getNumeroDeBadges());
			conquistaBean.setAssunto(conquista.getAssunto().getAssuntoBean());
			conquistaBean.setBadge(conquista.getBadge().getBadgeBean());
			
			conquistasBean.add(conquistaBean);
		};
		
		return conquistasBean;
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
