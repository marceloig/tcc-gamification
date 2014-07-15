package com.unigranrio.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.unigranrio.tcc.model.entity.Nivel;

public class NivelDAO {
	public void gravarNivel(Nivel nivel) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(nivel);
		manager.getTransaction().commit();

		manager.close();
	}

	public Nivel buscarNivelByNome(String nome) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();

		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Nivel> c = cb.createQuery(Nivel.class);
		Root<Nivel> root = c.from(Nivel.class);
		c.select(root);
		
		Predicate predicate = cb.equal(root.get("nome"), nome);
		c.where(predicate);

		TypedQuery<Nivel> query = manager.createQuery(c);
		Nivel nivel = query.getSingleResult();

		manager.close();
		factory.close();
		return nivel;
	}
}
