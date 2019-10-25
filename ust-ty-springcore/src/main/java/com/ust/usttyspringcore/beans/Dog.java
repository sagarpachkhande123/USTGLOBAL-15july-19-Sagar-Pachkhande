package com.ust.usttyspringcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog implements Animal {

	public Dog() {
		System.out.println("Object Created..");
	}
	@PostConstruct
	public void init() {
		System.out.println("Dog initialise..");

	}
	@PreDestroy
	public void destroy() {
		System.out.println("Dog DEstroy..");

	}
	
	
	@Override
	public void makesSound() {
		
		System.out.println("Me:- Dog Barking!");
	}

}
