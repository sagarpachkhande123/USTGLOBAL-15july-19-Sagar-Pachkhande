package com.tyss.usttyspringrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class ORMConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean ormConfiguration()
	{
		LocalContainerEntityManagerFactoryBean bean=
				new LocalContainerEntityManagerFactoryBean();
		bean.setPersistenceUnitName("employee-unit");
		return bean;
	}
}
