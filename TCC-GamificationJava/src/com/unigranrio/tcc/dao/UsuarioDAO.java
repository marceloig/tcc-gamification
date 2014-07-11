package com.unigranrio.tcc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.unigranrio.tcc.model.entity.Usuario;

@Repository
public class UsuarioDAO {

	public void gravarUsuario(Usuario usuario){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();    
		manager.persist(usuario);
		manager.getTransaction().commit();

		manager.close();
	}
	
	public Usuario buscarUsuarioByLogin(String login){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();

		Usuario usuario = manager.find(Usuario.class, "igmarcelo");

		return usuario;
	}
}
