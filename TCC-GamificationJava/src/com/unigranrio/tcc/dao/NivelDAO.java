package com.unigranrio.tcc.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.unigranrio.tcc.model.entity.Nivel;

public class NivelDAO {
	public void gravarNivel(Nivel nivel) {
		
		Connection.openConnection();
		Connection.getConnection().getTransaction().begin();
		Connection.getConnection().persist(nivel);
		Connection.getConnection().getTransaction().commit();

		Connection.closeConnection();
	}

	public Nivel buscarNivelByNome(String nome) {
		
		Connection.openConnection();
		CriteriaBuilder cb = Connection.getConnection().getCriteriaBuilder();
		CriteriaQuery<Nivel> c = cb.createQuery(Nivel.class);
		Root<Nivel> root = c.from(Nivel.class);
		c.select(root);
		
		Predicate predicate = cb.equal(root.get("nome"), nome);
		c.where(predicate);

		TypedQuery<Nivel> query = Connection.getConnection().createQuery(c);
		Nivel nivel = query.getSingleResult();

		Connection.closeConnection();

		return nivel;
	}
}
