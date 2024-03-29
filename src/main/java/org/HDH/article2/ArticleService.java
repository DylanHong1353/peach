package org.HDH.article2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * articleDaoλ₯? ?¬?©?΄? κΈ? λͺ©λ‘, μ‘°ν, μΆκ?, ?? , ?­? λ₯? ??€.
 * 
 * @author Jacob
 */
@Service
public class ArticleService {
	@Autowired
	ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	/**
	 * κΈ? λͺ©λ‘
	 */
	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	/**
	 * κΈ? μ‘°ν
	 */
	public void getArticle() {
		Article article = articleDao.getArticle("3");
		System.out.println(article);
	}

	/**
	 * κΈ? ?±λ‘?
	 */
	public void addArticle() {
		Article article = new Article();
		article.setTitle("λ³΄μ \"737 μΆλ½?¬κ³?, ?λͺ»λ ?Ό? ? λ³? ?λ¬?\"??μ²μ?Όλ‘? ?Έ? ");
		article.setContent(".........κΈ°μ¬?΄?©........................");
		article.setUserId("99"); // ??? ID??±? ?¬?©?? λ²νΈλ₯? ?? ₯??λ‘? μ½λ©?΄?Ό?¨
		article.setName("?κΈΈλ");
		if (articleDao.addArticle(article) > 0)
			System.out.println("κΈ?? μΆκ???΅??€.");
		else
			System.out.println("κΈ?? μΆκ??μ§? λͺ»ν?΅??€.");
	}

	/**
	 * κΈ? ?? 
	 */
	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("7");
		article.setTitle("This is modified title.");
		article.setContent("This is modified content");
		if (articleDao.updateArticle(article) > 0)
			System.out.println("κΈ?? ?? ??΅??€.");
		else
			System.out.println("κΈ?? ?? ?μ§? λͺ»ν?΅??€.");
	}

	/**
	 * κΈ? ?­? 
	 */
	public void deleteArticle() {
		if (articleDao.deleteArticle("8") > 0)
			System.out.println("κΈ?? ?­? ??΅??€.");
		else
			System.out.println("κΈ?? ?­? ?μ§? λͺ»ν?΅??€.");
	}
}
