package com.unigranrio.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.unigranrio.tcc.model.entity.Progresso;
import com.unigranrio.tcc.model.entity.Usuario;

@Repository
public class ProgressoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravarProgresso(Progresso progresso) {

		manager.persist(progresso);

	}

	public Progresso buscarProgressoById(long id) {

		Progresso progresso = manager.find(Progresso.class, id);

		return progresso;
	}

	public Progresso buscarProgressoByUsuario(Usuario usuario) {

		Query query = manager.createNamedQuery("Progresso.findByUsuario");
		query.setParameter("usuario", usuario);
		query.setMaxResults(1);
		Progresso progresso = (Progresso) query.getSingleResult();

		return progresso;
	}
}
