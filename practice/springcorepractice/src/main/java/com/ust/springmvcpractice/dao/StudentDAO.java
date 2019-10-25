package com.ust.springmvcpractice.dao;

import java.util.List;

import com.ust.springmvcpractice.dto.Student;

public interface StudentDAO {

	public boolean registerStudent(Student student);
	
	public boolean deleteStudent(int id);
	
	public boolean updateStudent(int id);
	
	public boolean authStudent(String email,String password);
	
	public List<Student> showAllstudents();
	
	
}
