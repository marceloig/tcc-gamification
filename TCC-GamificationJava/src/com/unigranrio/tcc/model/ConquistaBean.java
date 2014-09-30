package com.unigranrio.tcc.model;

public class ConquistaBean {

	private Long id;
	private BadgeBean badge;
	private AssuntoBean assunto;
	private int numeroDeBadges;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BadgeBean getBadge() {
		return badge;
	}

	public void setBadge(BadgeBean badge) {
		this.badge = badge;
	}

	public AssuntoBean getAssunto() {
		return assunto;
	}

	public void setAssunto(AssuntoBean assunto) {
		this.assunto = assunto;
	}

	public int getNumeroDeBadges() {
		return numeroDeBadges;
	}

	public void setNumeroDeBadges(int numeroDeBadges) {
		this.numeroDeBadges = numeroDeBadges;
	}
	
}
