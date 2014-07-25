package com.unigranrio.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.unigranrio.tcc.model.entity.Usuario;

@Repository
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravarUsuario(Usuario usuario) {

		manager.persist(usuario);
	}

	public Usuario buscarUsuarioByLogin(String login) {

		Usuario usuario = manager.find(Usuario.class, login);

		return usuario;
	}

	public List<Usuario> listarUsuarios() {

		Query query = manager.createNamedQuery("Usuario.findAll");
		List<Usuario> usuarios = query.getResultList();

		return usuarios;
	}

	public List<Usuario> listarUsuariosPorPontuacao() {
		Query query = manager.createNamedQuery("Usuario.listByPontuacao");
		query.setMaxResults(3);
		List<Usuario> usuarios = query.getResultList();

		return usuarios;
	}
	
	public List<Usuario> listarUsuariosMaiorMenorEIgual(int pontos) {
		Query query1 = manager.createNamedQuery("Usuario.findMaiorEIgual");
		query1.setParameter("pontos", pontos);
		query1.setMaxResults(3);
		List<Usuario> usuarios = query1.getResultList();
		
		Query query2 = manager.createNamedQuery("Usuario.findMenor");
		query2.setParameter("pontos", pontos);
		query2.setMaxResults(2);
		usuarios.addAll(query2.getResultList());

		return usuarios;
	}
}
