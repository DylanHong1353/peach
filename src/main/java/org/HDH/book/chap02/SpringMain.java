package org.HDH.book.chap02;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("chap02.xml");
		//Greeter g = ctx.getBean("greeter", Greeter.class);
		//System.out.println(g.greet());
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println(g1 == g2);
		ctx.close();
	}
}
