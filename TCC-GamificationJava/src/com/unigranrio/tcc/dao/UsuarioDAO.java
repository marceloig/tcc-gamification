package com.unigranrio.tcc.dao;

import org.springframework.stereotype.Repository;

import com.unigranrio.tcc.model.entity.Usuario;

@Repository
public class UsuarioDAO {

	public void gravarUsuario(Usuario usuario){
		
		Connection.openConnection();
		Connection.getConnection().getTransaction().begin();    
		Connection.getConnection().persist(usuario);
		Connection.getConnection().getTransaction().commit();

		Connection.closeConnection();
	}
	
	public Usuario buscarUsuarioByLogin(String login){
		
		Connection.openConnection();
		Usuario usuario = Connection.getConnection().find(Usuario.class, login);

		return usuario;
	}
}
