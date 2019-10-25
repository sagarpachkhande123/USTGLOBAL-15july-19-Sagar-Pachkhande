package com.tyss.usttyspringrest.dao;

import java.util.List;

import com.tyss.usttyspringrest.dto.Employee;

public interface EmployeeDAO {

	public boolean addEmployee(Employee employee);
	
	public boolean removeEmployee(int id);
	
	public boolean modifyEmployee(Employee employee);
	
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployees();
	
	
}
