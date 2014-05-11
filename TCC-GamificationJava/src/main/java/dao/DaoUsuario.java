package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import model.Usuario;

@Repository
public class DaoUsuario {

	public void gravarUsuario(Usuario usuario){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();    
		manager.persist(usuario);
		manager.getTransaction().commit();

		manager.close();
	}
	
	public Usuario buscarUsuarioByLogin(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
		EntityManager manager = factory.createEntityManager();

		Usuario usuario = manager.find(Usuario.class, "igormarcelo");

		return usuario;
	}
}
