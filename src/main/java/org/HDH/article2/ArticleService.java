package org.HDH.article2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * articleDao�? ?��?��?��?�� �? 목록, 조회, 추�?, ?��?��, ?��?���? ?��?��.
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
	 * �? 목록
	 */
	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	/**
	 * �? 조회
	 */
	public void getArticle() {
		Article article = articleDao.getArticle("3");
		System.out.println(article);
	}

	/**
	 * �? ?���?
	 */
	public void addArticle() {
		Article article = new Article();
		article.setTitle("보잉 \"737 추락?���?, ?��못된 ?��?�� ?���? ?���?\"??처음?���? ?��?��");
		article.setContent(".........기사?��?��........................");
		article.setUserId("99"); // ?��?��?�� ID?��?��?�� ?��?��?��?�� 번호�? ?��?��?��?���? 코딩?��?��?��
		article.setName("?��길동");
		if (articleDao.addArticle(article) > 0)
			System.out.println("�??�� 추�??��?��?��?��.");
		else
			System.out.println("�??�� 추�??���? 못했?��?��?��.");
	}

	/**
	 * �? ?��?��
	 */
	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("7");
		article.setTitle("This is modified title.");
		article.setContent("This is modified content");
		if (articleDao.updateArticle(article) > 0)
			System.out.println("�??�� ?��?��?��?��?��?��.");
		else
			System.out.println("�??�� ?��?��?���? 못했?��?��?��.");
	}

	/**
	 * �? ?��?��
	 */
	public void deleteArticle() {
		if (articleDao.deleteArticle("8") > 0)
			System.out.println("�??�� ?��?��?��?��?��?��.");
		else
			System.out.println("�??�� ?��?��?���? 못했?��?��?��.");
	}
}
