package com.dev.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_info")
public class EmployeeInfoBean {
	
	@Id
	@Column(name="emp_id")
	private int id;
	
	@Column(name="emp_name")
	private String Name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="designation")
	private String designation;
	
	@Column
	private String password;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "EmployeeInfoBean [id=" + id + ", Name=" + Name + ", age=" + age + ", salary=" + salary
				+ ", designation=" + designation + "]";
	}
	
}
