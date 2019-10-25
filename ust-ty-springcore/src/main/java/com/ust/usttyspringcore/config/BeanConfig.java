package com.ust.usttyspringcore.config;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ust.usttyspringcore.beans.Animal;
import com.ust.usttyspringcore.beans.Dog;
import com.ust.usttyspringcore.beans.HelloWorld;
import com.ust.usttyspringcore.beans.Human;

@Configuration
public class BeanConfig {
	
	@Bean(name="obj")//represent Bean Element same as <bean> element in .xml file 
//	@Bean(name="obj",autowire=Autowire.BY_TYPE)//we can do autowiring by this way
	public HelloWorld getHelloWorld() {
		HelloWorld helloWorld=new HelloWorld();
		helloWorld.setMsg("Hello from Config file..");
		helloWorld.setCount(20);
		HashMap<String, Integer> map=new HashMap<>();
		map.put("abc", 100);
		map.put("xyz", 890);
		helloWorld.setMap(map);
		//Animal an=getDog(); or Below line same this is UPcasting
//		helloWorld.setAnimal(getDog());
		return helloWorld;
	}
	
	@Bean(name="dog")
	@Scope("prototype")
	public Dog getDog()
	{
		
		return new Dog();
		
	}
	
	@Bean(name="human")
	public Human getHuman() {
		return new Human();
	}
	
}
