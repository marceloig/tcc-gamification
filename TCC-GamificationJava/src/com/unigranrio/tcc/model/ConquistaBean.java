package com.unigranrio.tcc.model;

import com.unigranrio.tcc.model.entity.Assunto;
import com.unigranrio.tcc.model.entity.Badge;

class ConquistaBean {

private Long id;
	
	
	private Badge badge;
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
}
