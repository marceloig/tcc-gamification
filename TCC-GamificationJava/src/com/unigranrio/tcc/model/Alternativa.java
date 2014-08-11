package com.unigranrio.tcc.model;

public enum Alternativa {

	ALTERNATIVA_A("A"),
	ALTERNATIVA_B("B"),
	ALTERNATIVA_C("C"),
	ALTERNATIVA_D("D");
	
	private final String alternativa;

	private Alternativa(String alternativa) {
		this.alternativa = alternativa;
	}

	public String getAlternativa() {
		return alternativa;
	}
	
	
}
