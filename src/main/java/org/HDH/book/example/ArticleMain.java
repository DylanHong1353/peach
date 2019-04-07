package org.HDH.book.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArticleMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("example.xml");
		
		// �Ʒ��� ���� �� ��� addArticle�� �ϰ� ���� ��� ArticleService�� ��� �������� ��
		//ArticleService s1 = new ArticleService();
		//s1.addArticle();
		
		// ���� �Ʒ��� ���� �� ��𼭵� ��������� �Ȱ��� articleService�� ȣ���ؼ� ��� (=�̱��ν��Ͻ�)
		ArticleService articleService = ctx.getBean("articleService", org.HDH.book.example.ArticleService.class);
		MemberService memberService = ctx.getBean("memberService", org.HDH.book.example.MemberService.class);
		
		articleService.addArticle();
		memberService.registerMember();
		
		ctx.close();
	}
}
