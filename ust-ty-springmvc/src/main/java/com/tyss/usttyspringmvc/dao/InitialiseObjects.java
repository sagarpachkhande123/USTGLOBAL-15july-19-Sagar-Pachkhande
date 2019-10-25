package com.tyss.usttyspringmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import com.tyss.usttyspringmvc.config.ORMConfig;

public class InitialiseObjects {

	@PersistenceUnit
	public EntityManagerFactory entityManagerFactory;
	public EntityManager entityManager;
	public EntityTransaction entityTransaction;
	public InitialiseObjects()
	{
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
}
