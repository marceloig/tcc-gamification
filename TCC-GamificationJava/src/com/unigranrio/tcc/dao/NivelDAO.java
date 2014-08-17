package com.unigranrio.tcc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.unigranrio.tcc.model.entity.Modulo;
import com.unigranrio.tcc.model.entity.Nivel;

@Repository
public class NivelDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public void gravarNivel(Nivel nivel) {
		
		manager.persist(nivel);
	
	}

	public Nivel buscarNivelByNome(String nome) {
		
		Query query = manager.createNamedQuery("Nivel.findByNome");
		query.setParameter("nome", nome);
		Nivel nivel = (Nivel) query.getSingleResult();

		return nivel;
	}
}
