package com.proxy;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyCglibProxy implements MethodInterceptor {
	private static Logger log = Logger.getLogger(MyCglibProxy.class);
	private Object target;

	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("开始");
		try {
			arg3.invokeSuper(arg0, arg2);
		} catch (Exception e) {
			log.info(e);
		}
	
		System.out.println("结束");
		return null;
	}

	public static void main(String[] args) throws Exception {
		MyCglibProxy mcp = new MyCglibProxy();
		Person p = new Person();
		Person proxy = (Person) mcp.getInstance(p);
		//proxy.getClass();
		proxy.print();

	}
}

class Person {
	public void print() throws Exception {
		System.out.println("print method  excute......");
		throw new Exception("print exception");
	}
}
