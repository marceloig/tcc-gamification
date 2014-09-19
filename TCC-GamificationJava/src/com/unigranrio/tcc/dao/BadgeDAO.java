package com.unigranrio.tcc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.unigranrio.tcc.model.entity.Badge;

@Repository
public class BadgeDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravarBadge(Badge badge) {
		
		manager.persist(badge);
		
	}
	
	public Badge buscarBadgeById(long id) {

		Badge badge = manager.find(Badge.class, id);

		return badge;
	}
}
