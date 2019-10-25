package com.tyss.usttyspringmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tyss.usttyspringmvc.dto.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	//	InitialiseObjects initialiseObjects;

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;


	@Override
	public Employee auth(String email, String password) {


		String jpql="from Employee where email=:email and password=:pwd";
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query=entityManager.createQuery(jpql);
			query.setParameter("email", email);
			query.setParameter("pwd", password);
			Employee employee=(Employee) query.getSingleResult();
			return employee;
		}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean registerEmployee(Employee employee) {

		if(checkEmail(employee.getEmail()))
		{
			return false;
		}
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction= entityManager.getTransaction();

		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
		return true;
	}

	//used whethere user is already registered or not
	private boolean checkEmail(String email)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction= entityManager.getTransaction();
		String jpql="from Employee where email=:email";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("email", email);
		try {
			query.getSingleResult();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(int id) {
		//		initialiseObjects=new InitialiseObjects();
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction= entityManager.getTransaction();
		transaction.begin();
		Employee employee=entityManager.find(Employee.class, id);
		if(employee==null)
		{
			return false;

		}
		entityManager.remove(employee);
		transaction.commit();
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) 
	{
		//		initialiseObjects=new InitialiseObjects();

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction= entityManager.getTransaction();

		transaction.begin();
		Employee emp=entityManager.find(Employee.class, employee.getId());
		if(emp==null)
		{
			return false;
		}
		emp.setName(employee.getName());		
		emp.setPassword(employee.getPassword());
		emp.setDob(employee.getDob());

		entityManager.persist(emp);
		transaction.commit();

		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		//		initialiseObjects=new InitialiseObjects();
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction= entityManager.getTransaction();

		String jpql="from Employee";
		Query query=entityManager.createQuery(jpql);
		List<Employee> employee=query.getResultList();
		return employee;

	}

}
