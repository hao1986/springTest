package com.ziyun.springDemo.listener;

import org.springframework.context.ApplicationListener;

public class CustomizationEvenListener implements ApplicationListener<CustomizationEvent> {

	@Override
	public void onApplicationEvent(CustomizationEvent event) {
		// TODO Auto-generated method stub
		System.out.println("CustomizationEvenListener init");
		System.out.println("~~~~~~~CustomizationEvent event start~~~~~~~~~~~~~");
		System.out.println(event.toString());
		System.out.println("~~~~~~~CustomizationEvent event end~~~~~~~~~~~~~");
	}

}
