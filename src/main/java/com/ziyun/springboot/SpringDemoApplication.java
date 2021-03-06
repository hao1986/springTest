package com.ziyun.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ziyun.springboot.listener.CustomizationEvenListener;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringDemoApplication.class);
		springApplication.addListeners(new CustomizationEvenListener());
		springApplication.run(args);
		System.out.println(springApplication.getListeners().toString());
		System.out.println(springApplication.getInitializers());

		
	}
}
