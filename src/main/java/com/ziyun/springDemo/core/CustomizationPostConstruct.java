package com.ziyun.springDemo.core;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.ziyun.springDemo.model.Person;

public class CustomizationPostConstruct implements InitializingBean, BeanFactoryAware, DisposableBean {
	
	private Person person;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	private String name;
	
	private String code;
	
	public void init() {
		System.out.println("--------CustomizationPostConstruct init-----------------");
	}
	
	public void javaDestroy() {
		System.out.println("---------CustomizationPostConstruct javaDestroy--------------");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("---------CustomizationPostConstruct postConstruct--------");
	}
	
	@PreDestroy
	public void preDestory() {
		System.out.println("---------CustomizationPostConstruct preDestory------------");
	}
	
	public CustomizationPostConstruct(Person person) {
		this.person = person;
		System.out.println("CustomizationPostConstruct start construct");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------CustomizationPostConstruct afterPropertiesSet------");
		
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("------CustomizationPostConstruct setBeanFactory------");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("------CustomizationPostConstruct destroy------");
		
	}
}
