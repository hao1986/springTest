package com.ziyun.springboot.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomizationBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("CustomizationBeanFactoryPostProcessor postProcessBeanFactory ");
		for(String beanDefinitionName: beanFactory.getBeanDefinitionNames()){
			System.out.println(beanDefinitionName);
			if("CustomizationFilterBean".equals(beanDefinitionName)){
				BeanDefinition beanDefinition = beanFactory.getBeanDefinition("CustomizationFilterBean");
				
				System.out.println(beanDefinition.getPropertyValues().toString());

				
			}
		}
	}

}
