package dao;

import model.StaffBean;

import java.util.List;


public interface StaffDao {

    List<StaffBean> findAll();
    
    void update(StaffBean staffBean);
    
    StaffBean findById(Integer id);
    
    void save(StaffBean sb);
    
    StaffBean findByMemberIdAndPassword(Integer staffId, String password);	
    
    List<? super Integer> getCountsAndPage(int pageSize, String hql);
    
	public List<StaffBean> findStaffByPage(int currentpage, int pagesize, String hql);
	
	
	//查詢
	String getById(String inputId);
	
	String getByName(String inputName);
	
	String getByPhone(String inputPhone);
	
	String getByPosition(String inputPosition);
	
	String getSelectHql(String partOfBody, String num);


}
