package com.unigranrio.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.unigranrio.tcc.model.entity.Usuario;

public class UsuarioDAO {

	public void gravarUsuario(Usuario usuario) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();

	}

	public Usuario buscarUsuarioByLogin(String login) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		Usuario usuario = manager.find(Usuario.class, login);

		return usuario;
	}

	public List<Usuario> listarUsuarios() {
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("Usuario.findAll");
		List<Usuario> usuarios = query.getResultList();

		return usuarios;
	}

	public List<Usuario> listarUsuariosPorPontuacao() {
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createNamedQuery("Usuario.listByPontuacao");
		query.setMaxResults(3);
		List<Usuario> usuarios = query.getResultList();

		return usuarios;
	}

	public List<Usuario> listarUsuariosMaiorMenorEIgual(int pontos) {
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();

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
