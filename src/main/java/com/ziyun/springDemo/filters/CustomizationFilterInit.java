package com.ziyun.springDemo.filters;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CustomizationFilterInit {
	
	@Bean
	public FilterRegistrationBean CustomizationFilterBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.addInitParameter("app_name", "springbootdemo");
		bean.setName("CustomizationFilterBean");
		bean.setFilter(new CustomizationFilters());
		bean.setUrlPatterns(Arrays.asList("/hello/*"));
		bean.setOrder(0);
		return bean;
	}
	
	@Bean
	public FilterRegistrationBean CustomizationFilterBeanT() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setName("CustomizationFilterBeanT");
		bean.setFilter(new CustomizationFiltersT());
		bean.setUrlPatterns(Arrays.asList("/*"));
		bean.setOrder(1);
		return bean;
	}

}
