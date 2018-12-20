package com.ziyun.springDemo.listener;

import org.springframework.context.ApplicationEvent;

public class CustomizationEvent extends ApplicationEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8111055667491222289L;

	private String name;
	
	private String status;

	public CustomizationEvent(String name, String status){
		super(name);
		System.out.println("CustomizationEvent init");
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomizationEvent [name=" + name + ", status=" + status + "]";
	}
	
}
