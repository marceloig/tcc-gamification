package com.unigranrio.tcc.model.entity;

import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Assunto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	@ManyToOne
	private Modulo modulo;
	
	@OneToMany
	private LinkedList<Exercicio> exercicios;
}
