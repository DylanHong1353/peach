package org.HDH.book.example;

public class MemberService {
	// MemberDao memberDao=new MemberDao();
	MemberDao memberDao;
	
	// Dependency Injection(DI) : ������ ����
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	public void registerMember() {
		memberDao.getMember();
	}
}
