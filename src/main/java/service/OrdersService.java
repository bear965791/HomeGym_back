package service;

import java.util.List;

import model.MemberBean;
import model.OrderBean;
import model.PageBean;

public interface OrdersService {
	
	public PageBean findOrdersByPage(int currentPage, int pageSize, String hql);

	public OrderBean findById(int id);
	
	public MemberBean findMemberByFk(int fk);
	
	public List<OrderBean> findOrderItemByPage(String hql);

	
	
}
