package com.ust.springmvcpractice.service;

import java.util.List;

import com.ust.springmvcpractice.dao.StudentDAO;
import com.ust.springmvcpractice.dto.Student;

public class StudentServiceImpl implements StudentService {

	
	StudentDAO dao;
	@Override
	public boolean registerStudent(Student student) {
		
		if(student.getEmail()==null)
		{
			return false;
		}
		return dao.registerStudent(student);
	}

	@Override
	public boolean deleteStudent(int id) {
		return false;
	}

	@Override
	public boolean updateStudent(int id) {
		return false;
	}

	@Override
	public boolean authStudent(String email, String password) {
		return false;
	}

	@Override
	public List<Student> showAllstudents() {
		return null;
	}

}
