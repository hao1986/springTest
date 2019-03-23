package com.ziyun.springboot.core;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DynamicBeanManage implements ApplicationContextAware {
	
	private DynamicBeanManage(){
		
	}

	private static ApplicationContext applicationContext;
	
	private static final Map<String, Object> emptyMap = Collections.emptyMap();

	public static Object registryBean(String beanId, Class<?> clazz) {
		return registryBeanDetails(beanId, clazz, emptyMap);
		
	}

	public static Object registryBeanDetails(String beanId, Class<?> clazz, Map<String, Object> details) {
		//先校验spring容器中是否已经有了bean，没有再注册到factory
		if (!applicationContext.containsBean(beanId)) {
			registryBeanFactory().registerBeanDefinition(beanId, registryBeanDefinition(clazz, details));
		}
		return applicationContext.getBean(beanId);
	}

	private static BeanDefinition registryBeanDefinition(Class<?> clazz, Map<String, Object> details) {
		BeanDefinitionBuilder beanBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
		BeanDefinition beanDefinition = beanBuilder.getBeanDefinition();
		if (!details.isEmpty()) {
			for (String key : details.keySet()) {
				beanDefinition.getPropertyValues().add(key, details.get(key));
			}
		}
		return beanDefinition;
	}

	private static DefaultListableBeanFactory registryBeanFactory() {
		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
		return (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		DynamicBeanManage.applicationContext = applicationContext;
	}

}
