package com.unigranrio.tcc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unigranrio.tcc.model.entity.Nivel;

public class NivelDAO {
	public void gravarNivel(Nivel nivel){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();    
		manager.persist(nivel);
		manager.getTransaction().commit();

		manager.close();
	}
	
	public Nivel buscarNivelByLogin(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();

		Nivel nivel = manager.find(Nivel.class, "Novato");

		return nivel;
	}
}
