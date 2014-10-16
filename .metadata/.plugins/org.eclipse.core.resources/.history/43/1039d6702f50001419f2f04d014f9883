package com.unigranrio.tcc.model.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unigranrio.tcc.model.AssuntoBean;
import com.unigranrio.tcc.model.ConquistaBean;
import com.unigranrio.tcc.model.ExercicioBean;

@Entity
@NamedQueries({
	@NamedQuery(name = "Assunto.allBadges", query = "SELECT a FROM Assunto a WHERE a.id = :id"),
})
public class Assunto {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;

	@ManyToOne
	private Modulo modulo;

	@OneToMany
	private List<Exercicio> exercicios;

	@OneToMany
	private List<Conquista> conquistas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	public List<Conquista> getConquistas() {
		return conquistas;
	}

	public void setConquistas(List<Conquista> conquistas) {
		this.conquistas = conquistas;
	}

	public List<ConquistaBean> getConquistasBean() {
		List<ConquistaBean> conquistasBean = new ArrayList<ConquistaBean>();
		for (Conquista conquista : conquistas) {
			ConquistaBean conquistaBean = conquista.getConquistaBean();
			conquistasBean.add(conquistaBean);
		}

		return conquistasBean;
	}

	public List<ExercicioBean> getExerciciosBean() {
		List<ExercicioBean> exerciciosBean = new ArrayList<ExercicioBean>();
		for (Exercicio exercicio : exercicios) {
			ExercicioBean exercicioBean = exercicio.getExercicioBean();
			exerciciosBean.add(exercicioBean);
		}

		return exerciciosBean;
	}

	public AssuntoBean getAssuntoBean() {
		AssuntoBean assuntoBean = new AssuntoBean();
		assuntoBean.setId(id);
		assuntoBean.setNome(nome);
		assuntoBean.setModulo(modulo.getModuloBean());

		return assuntoBean;
	}

}
