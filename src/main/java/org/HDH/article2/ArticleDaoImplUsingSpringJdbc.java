package org.HDH.article2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Spring JDBCÎ•? ?Ç¨?ö©?ï¥?Ñú ArticleDaoÎ•? Íµ¨ÌòÑ
 * 
 * @author Jacob
 */

@Repository("articleDao")
public class ArticleDaoImplUsingSpringJdbc implements ArticleDao {
	/**
	 * Î™©Î°ù Í∞??†∏?ò§?äî sql
	 */
	static final String LIST_ARTICLES = "SELECT articleId, title, name, cdate FROM article LIMIT 20";

	/**
	 * Í∏? 1Í∞? Í∞??†∏?ò§?äî sql
	 */
	static final String GET_ARTICLE = "SELECT articleId, title, content, name, cdate FROM article WHERE articleId=?";

	/**
	 * Í∏? ?ì±Î°ùÌïò?äî sql
	 */
	static final String ADD_ARTICLE = "INSERT INTO article(title, content, userId, name) VALUES (?,?,?,?)";

	/**
	 * Í∏? ?àò?†ï?ïò?äî sql
	 */
	static final String UPDATE_ARTICLE = "UPDATE article SET title=?, content=? WHERE articleId=?";

	/**
	 * Í∏? ?Ç≠?†ú?ïò?äî sql
	 */
	static final String DELETE_ARTICLE = "DELETE FROM article WHERE articleId=?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Í∏? Î™©Î°ù
	 */
	@Override
	public List<Article> listArticles() {
		return jdbcTemplate.query(LIST_ARTICLES, new BeanPropertyRowMapper<>(Article.class));
	}

	/**
	 * Í∏? ?ÉÅ?Ñ∏
	 */
	@Override
	public Article getArticle(String articleId) {
		return jdbcTemplate.queryForObject(GET_ARTICLE, new BeanPropertyRowMapper<>(Article.class), articleId);
	}

	/**
	 * Í∏? ?ì±Î°?
	 */
	@Override
	public int addArticle(Article article) {
		return jdbcTemplate.update(ADD_ARTICLE, article.getTitle(), article.getContent(), article.getUserId(),
				article.getName());
	}

	/**
	 * Í∏? ?àò?†ï
	 */
	@Override
	public int updateArticle(Article article) {
		return jdbcTemplate.update(UPDATE_ARTICLE, article.getTitle(), article.getContent(), article.getArticleId());
	}

	/**
	 * Í∏? ?Ç≠?†ú
	 */
	@Override
	public int deleteArticle(String articleId) {
		return jdbcTemplate.update(DELETE_ARTICLE, articleId);
	}
}
