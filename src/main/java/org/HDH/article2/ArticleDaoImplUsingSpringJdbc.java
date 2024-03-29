package org.HDH.article2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Spring JDBCë¥? ?¬?©?´? ArticleDaoë¥? êµ¬í
 * 
 * @author Jacob
 */

@Repository("articleDao")
public class ArticleDaoImplUsingSpringJdbc implements ArticleDao {
	/**
	 * ëª©ë¡ ê°?? ¸?¤? sql
	 */
	static final String LIST_ARTICLES = "SELECT articleId, title, name, cdate FROM article LIMIT 20";

	/**
	 * ê¸? 1ê°? ê°?? ¸?¤? sql
	 */
	static final String GET_ARTICLE = "SELECT articleId, title, content, name, cdate FROM article WHERE articleId=?";

	/**
	 * ê¸? ?±ë¡í? sql
	 */
	static final String ADD_ARTICLE = "INSERT INTO article(title, content, userId, name) VALUES (?,?,?,?)";

	/**
	 * ê¸? ?? ?? sql
	 */
	static final String UPDATE_ARTICLE = "UPDATE article SET title=?, content=? WHERE articleId=?";

	/**
	 * ê¸? ?­? ?? sql
	 */
	static final String DELETE_ARTICLE = "DELETE FROM article WHERE articleId=?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * ê¸? ëª©ë¡
	 */
	@Override
	public List<Article> listArticles() {
		return jdbcTemplate.query(LIST_ARTICLES, new BeanPropertyRowMapper<>(Article.class));
	}

	/**
	 * ê¸? ??¸
	 */
	@Override
	public Article getArticle(String articleId) {
		return jdbcTemplate.queryForObject(GET_ARTICLE, new BeanPropertyRowMapper<>(Article.class), articleId);
	}

	/**
	 * ê¸? ?±ë¡?
	 */
	@Override
	public int addArticle(Article article) {
		return jdbcTemplate.update(ADD_ARTICLE, article.getTitle(), article.getContent(), article.getUserId(),
				article.getName());
	}

	/**
	 * ê¸? ?? 
	 */
	@Override
	public int updateArticle(Article article) {
		return jdbcTemplate.update(UPDATE_ARTICLE, article.getTitle(), article.getContent(), article.getArticleId());
	}

	/**
	 * ê¸? ?­? 
	 */
	@Override
	public int deleteArticle(String articleId) {
		return jdbcTemplate.update(DELETE_ARTICLE, articleId);
	}
}
