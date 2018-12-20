package com.ziyun.springboot.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PersonConfig {
	
	@Bean
	public Person person(){
		Person person = new Person();
		person.setName("springDemo.test");
		person.setAddress("nanjing");
		return person;
	}

}
