package com.tyss.usttyspringrest.service;

import java.util.List;

import com.tyss.usttyspringrest.dto.Employee;

public interface EmployeeService {

	public boolean addEmployee(Employee employee);
	public boolean removeEmployee(int id);
	public boolean modifyEmployee(Employee employee);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployees();
}
