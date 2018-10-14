package com.velocity;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class VelocityDemo {
	public static void main(String[] args) throws Exception {
		//VelocityEngine engine = new VelocityEngine();
		Template template = Velocity.getTemplate("vm/test.vm");
		VelocityContext context = new VelocityContext();
		context.put("hello", "hello world!!!!!");
		StringWriter sw = new StringWriter();
		template.merge(context, sw);
		System.out.println(sw);
	}
}
