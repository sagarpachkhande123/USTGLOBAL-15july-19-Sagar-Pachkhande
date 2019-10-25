package com.ust.usttyspringcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ust.usttyspringcore.beans.Author;

public class AuthorApp {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("author.xml");
		Author author2=applicationContext.getBean(Author.class);
		System.out.println(author2.getName());
		author2.getWriter().write();
	}
}
