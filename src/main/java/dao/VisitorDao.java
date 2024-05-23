package dao;

import java.util.List;

import model.VisitorBean;

public interface VisitorDao {
	List<? super Integer> getCountsAndPage(int pageSize,String hql);
	public List<VisitorBean> findVisitorByPage(int currentpage, int pagesize, String hql);
	public VisitorBean findById(int id);
	public String getByInputValueHql(String intputValue);
	
}
