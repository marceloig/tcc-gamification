package com.unigranrio.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.unigranrio.tcc.model.entity.Assunto;
import com.unigranrio.tcc.model.entity.Conquista;
import com.unigranrio.tcc.model.entity.Usuario;

@Repository
public class ConquistaDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravarConquista(Conquista conquista) {

		manager.persist(conquista);
	}

	public Conquista atualizarConquista(Conquista conquista) {

		Conquista conquistaAtualizado = manager.merge(conquista);
		return conquistaAtualizado;

	}
	
	public void removerConquista(Conquista conquista) {

		manager.remove(conquista);

	}

	public List<Conquista> listarBadges(Assunto assunto) {
		Query query = manager.createNamedQuery("Conquista.allBadges");
		query.setParameter("assunto", assunto);
		List<Conquista> conquistas = query.getResultList();
		return conquistas;
		
	}

	public Conquista buscarConquista(long id) {
		Query query = manager.createNamedQuery("Conquista.getConquista");
		query.setParameter("id", id);
		Conquista badge = (Conquista) query.getSingleResult();
		return badge;

	}
	
	public Conquista buscarConquistaByUsuario(Usuario usuario) {
		Query query = manager.createNamedQuery("Conquista.getConquistaByUsuario");
		query.setParameter("usuario", usuario);
		query.setMaxResults(1);
		Conquista badge = (Conquista) query.getSingleResult();
		return badge;

	}
}
