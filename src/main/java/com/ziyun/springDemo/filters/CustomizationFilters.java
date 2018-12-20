package com.ziyun.springDemo.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

public class CustomizationFilters implements Filter {
	
	private static final String TOKEN="token";
	
	private static final String CONTENT_TYPE = "application/json; charset=UTF-8";
	private String appName;
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FileterName = " + filterConfig.getFilterName());
		appName = filterConfig.getInitParameter("app_name");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CustomizationFilters doFilter");
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		String headToken = httpRequest.getHeader(TOKEN);
		if (StringUtils.isEmpty(headToken)) {
			httpResponse.setContentType(CONTENT_TYPE);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("resp_code", 0);
			resultMap.put("resp_msg", "token is null");
			httpResponse.getWriter().print(JSON.toJSON(resultMap));
		} else {
			System.out.println(headToken);
			request.setAttribute("appName", appName);
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		System.out.println("CustomizationFilters destory");
		
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

}
