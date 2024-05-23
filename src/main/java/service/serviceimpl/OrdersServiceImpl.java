package service.serviceimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.MemberDao;
import dao.OrdersDao;
import dao.VideoDao;
import dao.daolmpl.OrdersDaoImpl;
import model.MemberBean;
import model.OrderBean;
import model.PageBean;
import model.VideoBean;
import service.OrdersService;
import util.HibernateUtils;

public class OrdersServiceImpl implements OrdersService {

	SessionFactory factory;
	OrdersDao ordersDao;
	MemberDao memberDao;
	VideoDao videoDao;
	
	
	public OrdersServiceImpl() {
		factory = HibernateUtils.getSessionFactory();
		ordersDao = new OrdersDaoImpl();
	}
	

	@Override
	public List<OrderBean> findOrderItemByPage(String hql) {
//		SessionFactory factory = HibernateUtils.getSessionFactory();
//    	Session session = factory.openSession();
		Session session = factory.getCurrentSession();
		List<OrderBean> bean = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = ordersDao.findOrderItemByPage(hql);
			for(OrderBean ob: bean) {
				for(VideoBean vb : ob.getCourse()) {
					System.out.println("=========="+vb);
					System.out.println("=========="+vb.getName());
//					bean = vb.getName();
				}
			}
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e);				
			}
		}
		return bean;
		
	}


	@Override
	public PageBean findOrdersByPage(int currentPage, int pageSize, String hql) {
		  long count; 
		  int totalpage;
		  Session session = factory.getCurrentSession();
		  PageBean pageBean = new PageBean();
		  Transaction tx = null;
		  try {
		   tx = session.beginTransaction();
		   // 返回資料庫中的商品總數
		   count = (long) ordersDao.getCountsAndPage(pageSize, hql).get(0);
		   // 計算總頁數
		   totalpage = (int) ordersDao.getCountsAndPage(pageSize, hql).get(1);
		   
		   // 查詢到的當前頁面要顯示的商品
		   List<OrderBean> order = ordersDao.findOrdersByPage(currentPage, pageSize, hql);
		   

		   pageBean.setCourseCount(count);
		   pageBean.setOrderBean(order);
		   pageBean.setCurrentPage(currentPage);
		   pageBean.setTotalPage(totalpage);

		   tx.commit();

		  } catch (Exception e) {
		   if (tx != null) {
		    tx.rollback();
		    e.printStackTrace();
		    throw new RuntimeException(e);
		   }
		  }
		  return pageBean;
	}

	@Override
	public OrderBean findById(int id) {
		
		Session session = factory.getCurrentSession();
		OrderBean bean = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = ordersDao.findById(id);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e);				
			}
		}
		return bean;
	}

	@Override
	public MemberBean findMemberByFk(int fk) {
		Session session = factory.getCurrentSession();
		MemberBean bean = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = ordersDao.findMemberByFk(fk);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e);				
			}
		}
		return bean;
	}
	
}
