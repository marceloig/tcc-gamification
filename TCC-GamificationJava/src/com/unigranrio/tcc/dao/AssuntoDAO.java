package com.unigranrio.tcc.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.unigranrio.tcc.model.entity.Assunto;
import com.unigranrio.tcc.model.entity.Modulo;

public class AssuntoDAO {

	public void gravarAssunto(Assunto assunto) {

		Connection.openConnection();
		Connection.getConnection().getTransaction().begin();
		Connection.getConnection().persist(assunto);
		Connection.getConnection().getTransaction().commit();

		Connection.closeConnection();
	}
	
	public void alterarAssunto(Assunto assunto) {

		Connection.openConnection();
		Connection.getConnection().getTransaction().begin();
		Connection.getConnection().merge(assunto);
		Connection.getConnection().getTransaction().commit();

		Connection.closeConnection();
	}

	public Assunto buscarAssuntoByNome(String nome) {
		Connection.openConnection();
		CriteriaBuilder cb = Connection.getConnection().getCriteriaBuilder();
		CriteriaQuery<Assunto> c = cb.createQuery(Assunto.class);
		Root<Assunto> root = c.from(Assunto.class);
		c.select(root);

		Predicate predicate = cb.equal(root.get("nome"), nome);
		c.where(predicate);

		TypedQuery<Assunto> query = Connection.getConnection().createQuery(c);
		Assunto assunto = query.getSingleResult();

		Connection.closeConnection();
		return assunto;
	}

	public List<Assunto> listarAssuntosByModulo(Modulo modulo) {
		Connection.openConnection();
		CriteriaBuilder cb = Connection.getConnection().getCriteriaBuilder();
		CriteriaQuery<Assunto> c = cb.createQuery(Assunto.class);
		Root<Assunto> root = c.from(Assunto.class);
		c.select(root);
		
		Predicate predicate = cb.equal(root.get("modulo"), modulo);
		c.where(predicate);

		TypedQuery<Assunto> query = Connection.getConnection().createQuery(c);
		List<Assunto> assuntos = query.getResultList();

		Connection.closeConnection();
		return assuntos;
	}
}
