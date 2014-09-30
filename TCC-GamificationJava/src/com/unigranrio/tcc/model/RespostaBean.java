package com.unigranrio.tcc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaBean {

	private String codigo;
	private String resposta;
	private boolean retorno;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String reposta) {
		this.resposta = reposta;
	}

	public boolean isRetorno() {
		return retorno;
	}

	public void setRetorno(boolean retorno) {
		this.retorno = retorno;
	}

}
