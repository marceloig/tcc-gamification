package com.unigranrio.tcc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.unigranrio.tcc.model.ConquistaBean;
@Entity
public class Conquista {

	@Id 
	@GeneratedValue
	private Long id;
	
	@ManyToOne(optional = false)
	private Badge badge;
	
	@ManyToOne(optional = false)
	private Assunto assunto;
	
	private int numeroDeBadges;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public int getNumeroDeBadges() {
		return numeroDeBadges;
	}

	public void setNumeroDeBadges(int numeroDeBadges) {
		this.numeroDeBadges = numeroDeBadges;
	}
	
	public ConquistaBean getConquistaBean(){
		ConquistaBean conquistaBean = new ConquistaBean();
		conquistaBean.setId(id);
		conquistaBean.setNumeroDeBadges(numeroDeBadges);
		conquistaBean.setAssunto(assunto.getAssuntoBean());
		conquistaBean.setBadge(badge.getBadgeBean());
		
		return conquistaBean;
	}
	
}
