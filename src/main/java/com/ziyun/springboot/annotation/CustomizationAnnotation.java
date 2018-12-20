package com.ziyun.springboot.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(value=RetentionPolicy.RUNTIME)
@Target(value=ElementType.METHOD)
@Documented
public @interface CustomizationAnnotation {
	String value() default "";
}
