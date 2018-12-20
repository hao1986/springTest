package com.ziyun.springDemo.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustAnnotationBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("CustAnnotationBeanPostProcessor postProcessBeforeInitialization " + beanName);
		if("characterEncodingFilter".equals(beanName)){
			System.out.println("characterEncodingFilter is skip!");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("CustAnnotationBeanPostProcessor postProcessAfterInitialization " + beanName);
		return bean;
	}

}
