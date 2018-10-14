package com.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocDemo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/spring/resource/app.xml");
		Object obj = context.getBean("iocService");
		IocService service = (IocService)obj;
		service.print();
	}
}
