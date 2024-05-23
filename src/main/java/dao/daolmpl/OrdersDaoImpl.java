package dao.daolmpl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.OrdersDao;
import model.MemberBean;
import model.OrderBean;
import util.HibernateUtils;

public class OrdersDaoImpl implements OrdersDao{
	
	SessionFactory factory;
	
	
	public OrdersDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}
	
	
	@Override
	public List<? super Integer> getCountsAndPage(int pageSize, String hql) {
		
		 int totalPages = 0;
		  long count = 0; 
		  List<? super Integer> pageInfo;
		  String countHql = "SELECT count(*) " + hql;
		  
		  Session session = factory.getCurrentSession();

		  List<Long> list = session.createQuery(countHql, Long.class).getResultList();
		  
		  System.out.println(list);
		  
		  if (list.size() > 0) {
		   count = list.get(0);
		  }
		  
		  totalPages = (int) (Math.ceil(count / (double) pageSize));
		  
		  pageInfo = Arrays.asList(count,totalPages);
		  
		  return pageInfo;
		
	}

	@Override
	public List<OrderBean> findOrdersByPage(int currentpage, int pagesize, String hql) {
		Session session = factory.getCurrentSession();
		List<OrderBean> list = session.createQuery(hql, OrderBean.class).setFirstResult((currentpage - 1) * pagesize)
				.setMaxResults(pagesize).getResultList();		
		for(OrderBean m:list) {
			System.out.println(m);
			
		}
		return list;
	}
	
	

	@Override
	public List<OrderBean> findOrderItemByPage(String hql) {
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
    	
    	
    	Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		
		
		List<OrderBean> list = session.createQuery(hql, OrderBean.class).getResultList();	
		
		return list;
	}


	@Override
	public OrderBean findById(int id) {
		OrderBean orders = null;
		Session session = factory.getCurrentSession();
		orders = (OrderBean) session.get(OrderBean.class, id);
		
		return orders;
	}

	@Override
	public MemberBean findMemberByFk(int fk) {
		OrderBean orders = null;
		MemberBean member = null;
		Session session = factory.getCurrentSession();
		orders = (OrderBean) session.get(OrderBean.class, fk);
		member = session.get(orders.getMember().getClass(), fk);
		
		
		return member;
	}


	@Override
	public String getByInputValueHql(String inputValue) {
		String hql; 
		String text = "'"+"%"+inputValue+"%"+"'";
		hql = "FROM OrderBean o WHERE o.orderId LIKE" +text+  " OR  o.member.memberName LIKE" +text ;
		return hql;
	}
	
	
	
	
	
	

}
