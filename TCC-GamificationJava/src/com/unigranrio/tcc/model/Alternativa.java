package com.unigranrio.tcc.model;

public enum Alternativa {

	A("A"),
	B("B"),
	C("C"),
	D("D");
	
	private final String opcao;

	private Alternativa(String opcao) {
		this.opcao = opcao;
	}

	public String getAlternativa() {
		return opcao;
	}
	
	
}
