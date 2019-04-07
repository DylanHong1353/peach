package org.HDH.book.chap04;

import org.HDH.book.chap03.RegisterRequest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MemberRegisterService를 테스트한다.<br>
 * component scan으로 빈을 생성한다.
 * 
 * @author Jacob
 */
public class MemberMainUsingComponentScan {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("chap04.xml");
		MemberRegisterService regService = ctx.getBean("memberRegisterService", MemberRegisterService.class);

		// registerRequest 초기화
		RegisterRequest req = new RegisterRequest();
		req.setEmail("hongdh1353@naver.com");
		req.setPassword("xxxx");
		req.setName("HDH");

		// 회원 등록
		regService.regist(req);
		ctx.close();
	}
}
