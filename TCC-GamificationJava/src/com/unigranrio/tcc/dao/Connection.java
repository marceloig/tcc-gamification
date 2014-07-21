package com.unigranrio.tcc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

	private static EntityManagerFactory factory;
	private static EntityManager manager;

	public static void openConnection(){
		factory = Persistence.createEntityManagerFactory("gamificationJava");
		manager = factory.createEntityManager();
	}
	public static EntityManager getConnection() {	

		return manager;
	}

	public static void closeConnection() {
		
		manager.close();
		factory.close();
	}
}
