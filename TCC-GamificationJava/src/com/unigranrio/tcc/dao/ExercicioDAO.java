package com.unigranrio.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.unigranrio.tcc.model.entity.Exercicio;
import com.unigranrio.tcc.model.entity.ExercicioJava;
import com.unigranrio.tcc.model.entity.ExercicioUml;
import com.unigranrio.tcc.model.entity.ImagemExercicio;

public class ExercicioDAO {

	public void gravarImagemExercicio(ImagemExercicio imgExercicio){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(imgExercicio);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
		
	}
	public void gravarExercicio(Exercicio exercicio) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(exercicio);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
		

	}
	
	public void gravarExercicioJava(Exercicio exercicioJava) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(exercicioJava);
		manager.getTransaction().commit();

		manager.close();
		factory.close();

	}
	
	public void gravarExercicioUml(ExercicioUml exercicioUml) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(exercicioUml);
		manager.getTransaction().commit();

		manager.close();
		factory.close();

	}
	
	public void alterarExercicioJava(ExercicioJava exJava) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(exJava);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}
	
	public void alterarExercicioUml(ExercicioUml exUml) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(exUml);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}
	
	public ExercicioJava buscarExercicioJavaById(int id) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createNamedQuery("ExercicioJava.findById");
		query.setParameter("id", id);
		ExercicioJava exJava = (ExercicioJava) query.getSingleResult();

		return exJava;
	}
	
	public ExercicioUml buscarExercicioUmlById(long id) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createNamedQuery("ExercicioUml.findById");
		query.setParameter("id", id);
		ExercicioUml exUml = (ExercicioUml) query.getSingleResult();

		return exUml;
	}
	
	public List<Exercicio> listarExercicios() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gamificationJava");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createNamedQuery("Exercicio.listAll");
		List<Exercicio> exercicios = query.getResultList();

		return exercicios;
	}
}
