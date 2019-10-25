package com.tyss.usttyspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.usttyspringrest.dto.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addEmployee(Employee employee) {

		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(employee);
			transaction.commit();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean removeEmployee(int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Employee employee;
		transaction.begin();
		employee= manager.find(Employee.class, id);
		try {
			manager.remove(employee);
			transaction.commit();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean modifyEmployee(Employee employee) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Employee emp;
		transaction.begin();
		emp= manager.find(Employee.class, employee.getId());
		try {
			emp.setDob(employee.getDob());
			emp.setName(employee.getName());
			emp.setPassword(employee.getPassword());
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	@Override
	public Employee getEmployee(int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Employee emp;
		emp=manager.find(Employee.class, id);
		if(emp!=null)
		{
			return emp;
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery("from Employee");
		List<Employee> employees=(List<Employee>) query.getResultList();
		return employees;
	}

}
