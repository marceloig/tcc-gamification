package com.unigranrio.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.unigranrio.tcc.model.entity.Modulo;

@Repository
public class ModuloDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void gravarModulo(Modulo modulo) {

		manager.persist(modulo);
		
	}

	public void alterarModulo(Modulo modulo) {

		manager.merge(modulo);
		
	}

	public Modulo buscarModuloByNome(String nome) {

		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Modulo> c = cb.createQuery(Modulo.class);
		Root<Modulo> root = c.from(Modulo.class);
		root.fetch("assuntos", JoinType.LEFT);
		c.select(root).distinct(true);

		Predicate predicate = cb.equal(root.get("nome"), nome);
		c.where(predicate);

		TypedQuery<Modulo> query = manager.createQuery(c);
		Modulo modulo = query.getSingleResult();

		return modulo;
	}
	
	public List<Modulo> listarModulos() {

		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Modulo> c = cb.createQuery(Modulo.class);
		Root<Modulo> root = c.from(Modulo.class);
		root.fetch("assuntos", JoinType.LEFT);
		c.select(root).distinct(true);

		TypedQuery<Modulo> query = manager.createQuery(c);
		List<Modulo> modulos = query.getResultList();
	
		return modulos;
	}
}
