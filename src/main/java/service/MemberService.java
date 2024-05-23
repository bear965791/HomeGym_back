package service;

import model.CoachBean;
import model.MemberBean;
import model.PageBean;

public interface MemberService {
	public PageBean findMemberByPage(int currentPage, int pageSize, String hql);
	
	public MemberBean findById(int id);
	
	public CoachBean findCoachByFk(int fk);
	
	

}
