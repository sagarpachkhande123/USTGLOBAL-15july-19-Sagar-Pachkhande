package com.ust.usttyspringcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.number.PercentStyleFormatter;

import com.ust.usttyspringcore.beans.Animal;
import com.ust.usttyspringcore.beans.HelloWorld;
import com.ust.usttyspringcore.beans.Pet;
public class App 
{
    public static void main( String[] args )
    {
    	HelloWorld helloWorld1=new HelloWorld();
    	helloWorld1.setMsg("Me: Hey..");
    	
    	
    	
    	System.out.println(helloWorld1.getMsg());
    	
//    	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
    	ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
    	
    	HelloWorld helloWorld2=applicationContext.getBean(HelloWorld.class);
       	System.out.println(helloWorld2.getMsg());
       	System.out.println(helloWorld2.getCount());
//       	helloWorld2.getAnimal().makesSound();
       	
       	Animal animal =(Animal)applicationContext.getBean(Animal.class);
       	animal.makesSound();
//       	System.out.println("**********************");
//       	
//       	Animal animal2=(Animal) applicationContext.getBean("dog");
////       	Animal animal1=(Animal) applicationContext.getBean("human");
////       	animal1.makesSound();
//       	animal2.makesSound();
//       	System.out.println("**********************");
//       	
//       	Pet pet=applicationContext.getBean(Pet.class);
//       	System.out.println(pet.getName());
//       	pet.getAnimal().makesSound();
       	
       System.out.println(helloWorld2.getMap());
       
       applicationContext.close();
       
    }
}
