package com.ziyun.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziyun.springboot.core.DynamicBeanManage;
import com.ziyun.springboot.model.Person;

@Controller
public class DemoController2 extends BaseController {
	
    @Autowired
    private Environment environment;
	
	@RequestMapping(value="/hello22", produces = "application/json; charset=UTF-8")
	public @ResponseBody String name(@RequestBody String name) {
		System.out.println(name + "-------" + name);

		System.out.println((DataSource)DynamicBeanManage.registryBean("name1", DataSource.class));
		
		
		Map<String, Object> paramsMap = new HashMap<String, Object>();		
		paramsMap.put("DriverClassName",environment.getProperty("spring.datasource.driver-class-name"));
		paramsMap.put("Url",environment.getProperty("spring.datasource.url"));
		paramsMap.put("username",environment.getProperty("spring.datasource.username"));
		paramsMap.put("Password",environment.getProperty("spring.datasource.password"));
 
		System.out.println((DataSource)DynamicBeanManage.registryBeanDetails("name2", DataSource.class, paramsMap));
			
		return null;
	}
	

}
