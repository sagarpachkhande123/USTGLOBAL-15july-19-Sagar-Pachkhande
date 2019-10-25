package com.dev.dao;

import java.sql.ResultSet;

import javax.persistence.Query;

public class ContactDAOJPAImpl implements ContactDAO{

	InitialiseObject initialiseObject;
	@Override
	public void showAll() {
		initialiseObject=new InitialiseObject();
		
		Query query=initialiseObject.entityManager.createQuery("from ContactInfoBean");
		
		
	}

	@Override
	public void searchContact() {
		
	}

	@Override
	public void operateContact() {
		
	}

	

}
