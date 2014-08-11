package com.unigranrio.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
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

		Query query = manager.createNamedQuery("Modulo.findByNome");
		query.setParameter("nome", nome);
		Modulo modulo = (Modulo) query.getSingleResult();

		return modulo;
	}

	public List<Modulo> listarModulos() {

		Query query = manager.createNamedQuery("Modulo.listAll");
		List<Modulo> modulos = query.getResultList();

		return modulos;
	}
}
