package org.HDH.book.chap08_1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMainUsingSpring {

	/**
	 * main() 메서?��
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("chap08_1.xml");
		MemberService memberService = ctx.getBean(MemberService.class);
		memberService.insertMember();
		memberService.selectAll();
		ctx.close();
	}
}
