package com.ust.usttyspringcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ust.usttyspringcore.beans.Animal;
import com.ust.usttyspringcore.beans.Dog;
import com.ust.usttyspringcore.beans.HelloWorld;
import com.ust.usttyspringcore.beans.Human;
import com.ust.usttyspringcore.config.BeanConfig;

public class AnnotationConfigApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(BeanConfig.class);
		HelloWorld obj=context.getBean(HelloWorld.class);
		System.out.println("Message: "+obj.getMsg());
		System.out.println("Count: "+obj.getCount());
		System.out.println("Map: "+obj.getMap());
	System.out.println("***********");
		obj.getAnimal().makesSound();
		System.out.println("***********");
		
		System.out.println("Scope ");
//		Animal animal1=context.getBean(Animal.class);
//		Animal animal2=context.getBean(Animal.class);
//		
//		System.out.println(animal1==animal2);
//		System.out.println("***********");
//		
		Dog dog=context.getBean(Dog.class);
		Dog dog1=context.getBean(Dog.class);
		
		System.out.println(dog==dog1);
		
		System.out.println("***********");
		Human human=context.getBean(Human.class);
		human.makesSound();		
	
		context.close();
	}
}
