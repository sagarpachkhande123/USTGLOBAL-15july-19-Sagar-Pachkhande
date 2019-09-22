package com.ustglobal.hotell_billing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Initialise_objects {

	static EntityManagerFactory entityManagerFactory=null;
	static EntityManager entityManager=null;
	static EntityTransaction transaction=null;

	Initialise_objects()
	{
		try {		
			entityManagerFactory=Persistence.createEntityManagerFactory("hoteldatabase");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
