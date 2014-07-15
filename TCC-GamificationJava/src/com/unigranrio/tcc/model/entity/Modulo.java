package com.unigranrio.tcc.model.entity;

import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Modulo {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@OneToMany
	private LinkedList<Assunto> assuntos;
}
