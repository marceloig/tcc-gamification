package com.unigranrio.tcc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.unigranrio.tcc.model.ImagemExercicioBean;

@Entity
public class ImagemExercicio {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String caminhoImagem;
	private String nomeImagem;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}
	
	public ImagemExercicioBean getImagemExercicioBean(){
		ImagemExercicioBean imgExercicioBean = new ImagemExercicioBean();
		imgExercicioBean.setNomeImagem(nomeImagem);
		imgExercicioBean.setCaminhoImagem(caminhoImagem);
		
		return imgExercicioBean;
	}

}
