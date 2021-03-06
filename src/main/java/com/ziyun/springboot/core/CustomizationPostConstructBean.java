package com.ziyun.springboot.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.ziyun.springboot.model.Person;

@Component
public class CustomizationPostConstructBean {
	
	@Autowired
	private Person person;
	
	@Bean(initMethod="init",destroyMethod="javaDestroy")
	public CustomizationPostConstruct postContruct(){
		return new CustomizationPostConstruct(person);
	}

}
