package com.ziyun.springDemo.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ziyun.springDemo.service.SpringDemoService;

@Component
@Aspect
public class CustAnnotationAspect {
	
	private static final String ANNO_VALUE = "annotationTest";
	
	@Autowired
	@Qualifier("service2")
	private SpringDemoService demoService;
	
	@Pointcut("@annotation(com.ziyun.springDemo.annotation.CustomizationAnnotation)")
	public void  CustomAnnotationAop(){
		System.out.println("--------CustAnnotationAspect CustomAnnotationAop-----");
	}
	
	@Before(value ="CustomAnnotationAop()")
	public void CustomAnnotationAopBefore(JoinPoint joinPoint) {
		System.out.println("--------CustAnnotationAspect before---------");
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		CustomizationAnnotation customizationAnnotation = methodSignature.getMethod().getAnnotation(CustomizationAnnotation.class);
		System.out.println("---name = " + customizationAnnotation.value());
		if(ANNO_VALUE.equals(customizationAnnotation.value())){
			System.out.println("------------do something 1----------");
		}else{
			System.out.println("------------do something 2----------");
		}
		
	}
	
	@After("CustomAnnotationAop()")
	public void CustomAnnotationAopAfter() {
		System.out.println("--------CustAnnotationAspect after---------");
		System.out.println(demoService.getPersons().toString());
	}

}
