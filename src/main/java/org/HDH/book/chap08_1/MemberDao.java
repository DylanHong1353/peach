package org.HDH.book.chap08_1;

import java.util.List;

import org.HDH.book.chap03.Member;

/**
 * p.184 [ë¦¬ìŠ¤?Š¸ 8.2] MemberDao ë¥? interfaceë¡? ?ˆ˜? •<br>
 * ?šŒ?› ?…Œ?´ë¸”ì„ ì¡°ì‘?•˜?Š” Data Access Object
 * 
 * @author Jacob
 */
public interface MemberDao {
	/**
	 * ?´ë©”ì¼ë¡? ?šŒ?› ? •ë³? ê°?? ¸?˜´
	 */
	Member selectByEmail(String email);

	/**
	 * ?šŒ?›? •ë³? ???¥
	 */
	void insert(Member member);

	/**
	 * ?šŒ?›? •ë³? ?ˆ˜? •
	 */
	void update(Member member);

	/**
	 * ?šŒ?› ëª©ë¡
	 */
	List<Member> selectAll(int offset, int count);
}
