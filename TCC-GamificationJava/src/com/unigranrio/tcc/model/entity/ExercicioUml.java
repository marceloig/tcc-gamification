package com.unigranrio.tcc.model.entity;

import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class ExercicioUml extends Exercicio{
	
	private ArrayList<String> opcaoResposta;
	private String resposta;
	
}
