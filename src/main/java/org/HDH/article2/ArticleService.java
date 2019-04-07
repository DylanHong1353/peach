package org.HDH.article2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * articleDaoë¥? ?‚¬?š©?•´?„œ ê¸? ëª©ë¡, ì¡°íšŒ, ì¶”ê?, ?ˆ˜? •, ?‚­? œë¥? ?•œ?‹¤.
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
	 * ê¸? ëª©ë¡
	 */
	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	/**
	 * ê¸? ì¡°íšŒ
	 */
	public void getArticle() {
		Article article = articleDao.getArticle("3");
		System.out.println(article);
	}

	/**
	 * ê¸? ?“±ë¡?
	 */
	public void addArticle() {
		Article article = new Article();
		article.setTitle("ë³´ì‰ \"737 ì¶”ë½?‚¬ê³?, ?˜ëª»ëœ ?„¼?„œ ? •ë³? ?•Œë¬?\"??ì²˜ìŒ?œ¼ë¡? ?¸? •");
		article.setContent(".........ê¸°ì‚¬?‚´?š©........................");
		article.setUserId("99"); // ?›?˜?Š” ID?ƒ?„±?‹œ ?‚¬?š©?–ˆ?˜ ë²ˆí˜¸ë¥? ?…? ¥?•˜?„ë¡? ì½”ë”©?•´?•¼?¨
		article.setName("?™ê¸¸ë™");
		if (articleDao.addArticle(article) > 0)
			System.out.println("ê¸??„ ì¶”ê??–ˆ?Šµ?‹ˆ?‹¤.");
		else
			System.out.println("ê¸??„ ì¶”ê??•˜ì§? ëª»í–ˆ?Šµ?‹ˆ?‹¤.");
	}

	/**
	 * ê¸? ?ˆ˜? •
	 */
	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("7");
		article.setTitle("This is modified title.");
		article.setContent("This is modified content");
		if (articleDao.updateArticle(article) > 0)
			System.out.println("ê¸??„ ?ˆ˜? •?–ˆ?Šµ?‹ˆ?‹¤.");
		else
			System.out.println("ê¸??„ ?ˆ˜? •?•˜ì§? ëª»í–ˆ?Šµ?‹ˆ?‹¤.");
	}

	/**
	 * ê¸? ?‚­? œ
	 */
	public void deleteArticle() {
		if (articleDao.deleteArticle("8") > 0)
			System.out.println("ê¸??„ ?‚­? œ?–ˆ?Šµ?‹ˆ?‹¤.");
		else
			System.out.println("ê¸??„ ?‚­? œ?•˜ì§? ëª»í–ˆ?Šµ?‹ˆ?‹¤.");
	}
}
