package com.unigranrio.tcc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.unigranrio.tcc.model.entity.Nivel;

@Repository
public class NivelDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravarNivel(Nivel nivel) {
	
		manager.persist(nivel);
	
	}

	public Nivel buscarNivelByNome(String nome) {
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Nivel> c = cb.createQuery(Nivel.class);
		Root<Nivel> root = c.from(Nivel.class);
		c.select(root);
		
		Predicate predicate = cb.equal(root.get("nome"), nome);
		c.where(predicate);

		TypedQuery<Nivel> query = manager.createQuery(c);
		Nivel nivel = query.getSingleResult();

		return nivel;
	}
}
