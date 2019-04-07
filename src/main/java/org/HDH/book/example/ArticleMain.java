package org.HDH.book.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArticleMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("example.xml");
		
		// 아래와 같이 할 경우 addArticle을 하고 싶을 경우 ArticleService를 계속 만들어줘야 됨
		//ArticleService s1 = new ArticleService();
		//s1.addArticle();
		
		// 따라서 아래와 같이 해 어디서든 여러사람이 똑같은 articleService를 호출해서 사용 (=싱글인스턴스)
		ArticleService articleService = ctx.getBean("articleService", org.HDH.book.example.ArticleService.class);
		MemberService memberService = ctx.getBean("memberService", org.HDH.book.example.MemberService.class);
		
		articleService.addArticle();
		memberService.registerMember();
		
		ctx.close();
	}
}
