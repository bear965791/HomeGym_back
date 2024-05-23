package dao;

import java.util.List;

import model.CoachBean;
import model.MemberBean;

public interface MemberDao {
	
	List<? super Integer> getCountsAndPage(int pageSize, String hql);
	public List<MemberBean> findMemberByPage(int currentpage, int pagesize, String hql);
	public MemberBean findById(int id);
	public CoachBean findCoachByFk(int fk);
	public String getByInputValueHql(String inputValue);
	public String getByInputEmailHql(String inputEmail);
	public String getRoleHql(String role);
	

}
