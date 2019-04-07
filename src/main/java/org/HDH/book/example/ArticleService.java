package org.HDH.book.example;

public class ArticleService {
	// MemberDao memberDao=new MemberDao
	MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	public void addArticle() {
		memberDao.getMember();
	}
}
