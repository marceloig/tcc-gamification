package com.unigranrio.tcc.model;

import java.util.List;

public class ExercicioJavaBean extends ExercicioBean{

	private List<String> exemplosCodigos;
	private String codigoReferencia;
	private String respostaJava;

	public List<String> getExemplosCodigos() {
		return exemplosCodigos;
	}

	public void setExemplosCodigos(List<String> exemplosCodigos) {
		this.exemplosCodigos = exemplosCodigos;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	public String getRespostaJava() {
		return respostaJava;
	}

	public void setRespostaJava(String respostaJava) {
		this.respostaJava = respostaJava;
	}
}
