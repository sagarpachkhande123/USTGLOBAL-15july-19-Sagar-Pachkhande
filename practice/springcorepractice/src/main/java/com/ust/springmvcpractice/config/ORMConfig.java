package com.ust.springmvcpractice.config;

import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class ORMConfig {

	@Bean
	public LocalEntityManagerFactoryBean ormConfiguration() {
		LocalEntityManagerFactoryBean bean=new LocalEntityManagerFactoryBean();
		
		bean.setPersistenceUnitName("student-unit");
		
		return bean;

	}
}
