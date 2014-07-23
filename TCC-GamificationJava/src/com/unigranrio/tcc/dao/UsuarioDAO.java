package com.unigranrio.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> c = cb.createQuery(Usuario.class);
		Root<Usuario> root = c.from(Usuario.class);
		c.select(root);

		TypedQuery<Usuario> query = manager.createQuery(c);
		List<Usuario> usuarios = query.getResultList();
	
		return usuarios;
	}
}
