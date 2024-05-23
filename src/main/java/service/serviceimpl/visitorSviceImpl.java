package service.serviceimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.VisitorDao;
import dao.daolmpl.VisitorDaolmpl;
import model.PageBean;
import model.VisitorBean;
import service.VisitorService;
import util.HibernateUtils;

public class visitorSviceImpl implements VisitorService {
	
	SessionFactory factory;
	VisitorDao visitorDao;

	public visitorSviceImpl() {
		factory = HibernateUtils.getSessionFactory();
		visitorDao = new VisitorDaolmpl();
	}

	@Override
	public PageBean findVisitorByPage(int currentPage, int pageSize, String hql) {
		long count; 
		  int totalpage;
		  Session session = factory.getCurrentSession();
		  PageBean pageBean = new PageBean();
		  Transaction tx = null;
		  try {
		   tx = session.beginTransaction();
		   // 返回資料庫中的商品總數
		   count = (long) visitorDao.getCountsAndPage(pageSize, hql).get(0);
		   // 計算總頁數
		   totalpage = (int) visitorDao.getCountsAndPage(pageSize, hql).get(1);
		   
		   // 查詢到的當前頁面要顯示的商品
		   List<VisitorBean> course = visitorDao.findVisitorByPage(currentPage, pageSize, hql);

		   pageBean.setCourseCount(count);
		   pageBean.setVisitorBean(course);
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

}
