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

	public void atualizarPontosUsuario(Usuario usuario) {
		Query query = manager.createNamedQuery("Usuario.updatePontos");
		query.setParameter("pontos", usuario.getPontos());
		query.setParameter("login", usuario.getLogin());
		query.executeUpdate();
	}
	
	public void atualizarPosicaoUsuario(Usuario usuario) {
		Query query = manager.createNamedQuery("Usuario.updatePosicao");
		query.setParameter("posicao", usuario.getPosicao());
		query.setParameter("login", usuario.getLogin());
		query.executeUpdate();
	}

	public List<Usuario> listarUsuarios() {

		Query query = manager.createNamedQuery("Usuario.findAll");
		List<Usuario> usuarios = query.getResultList();

		return usuarios;
	}

	public List<Usuario> listarUsuariosPorPontuacao() {

		Query query = manager.createNamedQuery("Usuario.listByPontuacao");
		List<Usuario> usuarios = query.getResultList();

		return usuarios;
	}
	
	public long buscarPosicaoUsuario(int pontos) {

		Query query = manager.createNamedQuery("Usuario.getPosicao");
		query.setParameter("pontos", pontos);
		long posicao =  (long) query.getSingleResult();
		posicao = posicao + 1;
		return posicao;
	}

}
