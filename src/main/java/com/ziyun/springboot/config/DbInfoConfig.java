package com.ziyun.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="classpath:dbinfo.properties")
public class DbInfoConfig {
	
	@Value("${dbinfo.source.name}")
	private String sourceName;
	
	@Value("${dbinfo.source.name}")
	private String source;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	

}
