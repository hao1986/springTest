package com.ziyun.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziyun.springboot.annotation.CustomizationAnnotation;
import com.ziyun.springboot.config.DbInfoConfig;
import com.ziyun.springboot.listener.CustomizationEvent;
import com.ziyun.springboot.model.Person;

@Controller
public class DemoController extends BaseController {
	
	@Autowired
	private Person person;
	
	@Value("${app.name}")
	private String appName;
	
	@Autowired
	private DbInfoConfig dbInfoConfig;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	@CustomizationAnnotation("annotationTest")
	@RequestMapping(value="/hello", produces = "application/json; charset=UTF-8")
	public @ResponseBody String name(@RequestBody String name) {
		System.out.println(appName + "-------" + name);
		System.out.println("dbInfo source = " + dbInfoConfig.getSourceName());
		CustomizationEvent customizationEvent = new CustomizationEvent("111","0");
		applicationEventPublisher.publishEvent(customizationEvent);
		return responseToJson(0, "success", person, customizationEvent);
	}
	
	@RequestMapping(value="/hello/name", produces = "application/json; charset=UTF-8")
	public @ResponseBody String getName(@RequestBody String name) {
		System.out.println(appName + "-------" + name);
		System.out.println("dbInfo source = " + dbInfoConfig.getSource());
		CustomizationEvent customizationEvent = new CustomizationEvent("111","0");
		applicationEventPublisher.publishEvent(customizationEvent);
		return responseToJson(0, "success", person, customizationEvent);
	}

}
