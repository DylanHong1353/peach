package org.HDH.book.chap08_1;

import java.util.List;

import org.HDH.book.chap03.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * ?Έ?°??΄?€ MemberDao? κ΅¬νμ²?. SpringJdbcλ₯? ?¬?©?΄? κ΅¬ν
 * 
 * @author Jacob
 */
@Repository("memberDao")
public class MemberDaoImplUsingSpringJdbc implements MemberDao {

	static final String SELECT_BY_EMAIL = "SELECT memberId, email, name FROM member WHERE email=?";

	static final String INSERT = "INSERT member(email, password, name) VALUES(?, sha2(?,256), ?)";

	static final String UPDATE = "UPDATE member SET email=?, password=sha2(?,256), name=? WHERE memberId=?";

	static final String SELECT_ALL = "SELECT memberId, email, name FROM member ORDER BY memberId desc LIMIT ?,?";

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * jdbcTemplate setter for injection
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * p.194? memberRowMapper<br>
	 * Member ?€λΈμ ?Έ?? member ??΄λΈμ ? ?? λ§€ν?? rowMapper
	 */
	RowMapper<Member> memberRowMapper = new BeanPropertyRowMapper<>(Member.class);

	/**
	 * p.192 [λ¦¬μ€?Έ 8.8]? selectByEmail() λ©μ? ?? 
	 */
	@Override
	public Member selectByEmail(String email) {
		return jdbcTemplate.queryForObject(SELECT_BY_EMAIL, memberRowMapper, email);
	}

	/**
	 * p.201 [λ¦¬μ€?Έ 8.12]? insert() λ©μ? ?? 
	 */
	@Override
	public void insert(Member member) {
		jdbcTemplate.update(INSERT, member.getEmail(), member.getPassword(), member.getName());
	}

	/**
	 * p.198 [λ¦¬μ€?Έ 8.11]? update() λ©μ? ?? 
	 */
	@Override
	public void update(Member member) {
		jdbcTemplate.update(UPDATE, member.getEmail(), member.getPassword(), member.getName(), member.getMemberId());
	}

	/**
	 * p.195 [λ¦¬μ€?Έ 8.9] selectAll() λ©μ? ?? 
	 */
	@Override
	public List<Member> selectAll(int offset, int count) {
		return jdbcTemplate.query(SELECT_ALL, memberRowMapper, 0, 100);
	}
}
