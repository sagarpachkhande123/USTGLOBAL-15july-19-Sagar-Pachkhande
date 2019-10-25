package com.dev.dao;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dev.dto.EmployeeInfoBean;

public class EmployeeDAOJpaImpl implements EmployeeDAO  {

	@Override
	public EmployeeInfoBean searchEmployee(int id) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("servletdatabase");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EmployeeInfoBean bean=null;
		try {
			bean = entityManager.find(EmployeeInfoBean.class, id);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean bean) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("servletdatabase");
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(bean);
			entityManager.getTransaction().commit();
			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {


		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("servletdatabase");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EmployeeInfoBean bean=null;
		try {
			entityManager.getTransaction().begin();

			bean=entityManager.find(EmployeeInfoBean.class,id);
			if(bean!=null)
			{
				entityManager.remove(bean);
				entityManager.getTransaction().commit();
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean UpdateEmployee(int id, String name) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("servletdatabase");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EmployeeInfoBean bean=null;
		try {
			entityManager.getTransaction().begin();

			bean=entityManager.find(EmployeeInfoBean.class,id);
			if(bean!=null)
			{
				bean.setName(name);
				entityManager.getTransaction().commit();
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public EmployeeInfoBean login(int empid, String password) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("servletdatabase");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EmployeeInfoBean bean=null;
		
		String qry="from EmployeeInfoBean where id=:id and password=:pwd";
		
		Query query=entityManager.createQuery(qry);
		query.setParameter("id",empid);
		query.setParameter("pwd",password);
//		
//		Query query= (Query) entityManager.createQuery(qry);
//		((javax.persistence.Query) query).setParameter("id",empid);
//		((javax.persistence.Query) query).setParameter("pwd",password);
//		
		
		try {
			bean=(EmployeeInfoBean) query.getSingleResult();
		}catch(Exception e)
		{
			
			e.printStackTrace();;
		}
		return bean;
		
	}//End LOgin
}

