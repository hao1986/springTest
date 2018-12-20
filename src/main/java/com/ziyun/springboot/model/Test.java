package com.ziyun.springboot.model;


public class Test {

	private static final String[] WEB_ENVIRONMENT_CLASSES = { "javax.servlet.Servlet","2",
	"org.springframework.web.context.ConfigurableWebApplicationContext" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkAndEvictOperation();

	}
	
	private static int checkAndEvictOperation(){
		for (String className : WEB_ENVIRONMENT_CLASSES) {
			System.out.println(className);
			if("2".equals(className)){
				return 0;
			}
		}
		return 1;
	}

}
