package com.ustglobal.usttyspringboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ustglobal.usttyspringboot.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Transactional //delete and update
	@Modifying //delete and update
	@Query("update Employee set name=:name,  password=:password where id=:id")
	public void update(@Param("name")String name,@Param("password")String password,
			@Param("id")int id) ;
	
	public Employee findByEmail(String email);
	
	public List<Employee> findByName(String name);
}
