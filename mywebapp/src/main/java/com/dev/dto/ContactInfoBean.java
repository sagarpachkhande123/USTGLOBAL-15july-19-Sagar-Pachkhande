package com.dev.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class ContactInfoBean {


	@Id
	@Column
	int id;
	@Column
	String name;
	@Column
	int number;
	@Column
	String groupp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getGroupp() {
		return groupp;
	}
	public void setGroupp(String groupp) {
		this.groupp = groupp;
	}

}
