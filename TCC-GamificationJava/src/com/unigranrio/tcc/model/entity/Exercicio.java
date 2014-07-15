package com.unigranrio.tcc.model.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Exercicio {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private String descricao;
	private ArrayList<String> exemplos;
	private ArrayList<String> dicas;

	@ManyToOne(optional = false)
	private Assunto assunto;

}
