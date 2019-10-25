package com.dev.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InitialiseObject {
	EntityManagerFactory entityManagerFactory=null;
	EntityManager entityManager=null;
	EntityTransaction entityTransaction=null;
	public InitialiseObject() {
		entityManagerFactory=Persistence.createEntityManagerFactory("");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();

	}
}
