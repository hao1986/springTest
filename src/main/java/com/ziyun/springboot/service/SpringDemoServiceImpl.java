package com.ziyun.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ziyun.springboot.model.Person;

@Service
public class SpringDemoServiceImpl implements SpringDemoService {

	@Override
	public List<Person> getPersons() {
		List<Person> list =  new ArrayList<Person>();
		Person person = new Person();
		person.setAddress("0123456789");
		person.setName("test");
		list.add(person);
		return list;
	}

}
