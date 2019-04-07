package org.HDH.book.chap04;

import org.HDH.book.chap03.RegisterRequest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MemberRegisterService�� �׽�Ʈ�Ѵ�.<br>
 * component scan���� ���� �����Ѵ�.
 * 
 * @author Jacob
 */
public class MemberMainUsingComponentScan {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("chap04.xml");
		MemberRegisterService regService = ctx.getBean("memberRegisterService", MemberRegisterService.class);

		// registerRequest �ʱ�ȭ
		RegisterRequest req = new RegisterRequest();
		req.setEmail("hongdh1353@naver.com");
		req.setPassword("xxxx");
		req.setName("HDH");

		// ȸ�� ���
		regService.regist(req);
		ctx.close();
	}
}