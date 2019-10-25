package com.dev.dao;

import com.dev.dto.EmployeeInfoBean;

public interface EmployeeDAO {

	public EmployeeInfoBean searchEmployee(int id);
	
	public boolean addEmployee(EmployeeInfoBean bean);
	
	public boolean deleteEmployee(int id);
	
	public boolean UpdateEmployee(int id,String name);
	
	//Session Login Form
	public EmployeeInfoBean login(int empid,String password);
}
