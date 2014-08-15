package com.unigranrio.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.unigranrio.tcc.model.entity.Modulo;

public class ModuloDAO {

	public void gravarModulo(Modulo modulo) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(modulo);
		manager.getTransaction().commit();

		manager.close();
		factory.close();

	}

	public void alterarModulo(Modulo modulo) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(modulo);
		manager.getTransaction().commit();

		manager.close();
		factory.close();

	}

	public Modulo buscarModuloByNome(String nome) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("Modulo.findByNome");
		query.setParameter("nome", nome);
		Modulo modulo = (Modulo) query.getSingleResult();

		return modulo;
	}

	public List<Modulo> listarModulos() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("Modulo.listAll");
		List<Modulo> modulos = query.getResultList();

		return modulos;
	}
}
