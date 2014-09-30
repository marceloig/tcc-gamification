package com.unigranrio.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.unigranrio.tcc.model.entity.Assunto;
import com.unigranrio.tcc.model.entity.Conquista;
import com.unigranrio.tcc.model.entity.ExercicioJava;
import com.unigranrio.tcc.model.entity.Modulo;

@Repository
public class AssuntoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void gravarAssunto(Assunto assunto) {
		
		manager.persist(assunto);
		
	}
	
	public void alterarAssunto(Assunto assunto) {
		
		manager.merge(assunto);
		
	}

	public Assunto buscarAssuntoById(long id) {
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Assunto> c = cb.createQuery(Assunto.class);
		Root<Assunto> root = c.from(Assunto.class);
		c.select(root);

		Predicate predicate = cb.equal(root.get("id"), id);
		c.where(predicate);

		TypedQuery<Assunto> query = manager.createQuery(c);
		Assunto assunto = query.getSingleResult();

		return assunto;
	}

	public List<Assunto> listarAssuntosByModulo(Modulo modulo) {
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Assunto> c = cb.createQuery(Assunto.class);
		Root<Assunto> root = c.from(Assunto.class);
		c.select(root);
		
		Predicate predicate = cb.equal(root.get("modulo"), modulo);
		c.where(predicate);

		TypedQuery<Assunto> query = manager.createQuery(c);
		List<Assunto> assuntos = query.getResultList();

		return assuntos;
	}
	
}
