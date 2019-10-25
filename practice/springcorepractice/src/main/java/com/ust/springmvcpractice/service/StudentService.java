package com.ust.springmvcpractice.service;

import java.util.List;

import com.ust.springmvcpractice.dto.Student;

public interface StudentService {

	public boolean registerStudent(Student student);

	public boolean deleteStudent(int id);

	public boolean updateStudent(int id);

	public boolean authStudent(String email,String password);

	public List<Student> showAllstudents();
}
