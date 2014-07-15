package com.unigranrio.tcc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Badge {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String descricao;
	private String nomeImagem;
	
}
