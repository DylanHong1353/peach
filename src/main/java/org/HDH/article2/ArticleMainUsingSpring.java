package org.HDH.article2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ArticleServiceë¥? ?…Œ?Š¤?Š¸?•˜?Š” main
 * 
 * @author Jacob
 */
public class ArticleMainUsingSpring {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("article2.xml");
		ArticleService articleService = context.getBean("articleService", ArticleService.class);
		context.close();

		articleService.addArticle();
		articleService.listArticles();
	}
}
