package service.serviceimpl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.VideoDao;
import dao.daolmpl.VideoDaoImpl;
import model.PageBean;
import model.VideoBean;
import service.ClassService;
import util.HibernateUtils;


public class ClassServiceImpl implements ClassService {
	
	SessionFactory factory;
	VideoDao videoDao;

	
	public ClassServiceImpl() {
		factory = HibernateUtils.getSessionFactory();
		videoDao = new VideoDaoImpl();
	}

	
	@Override
	public VideoBean findById(int pk) {
		Session session = factory.getCurrentSession();
		VideoBean bean = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = videoDao.findById(pk);
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
	public void delete(int pk) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			videoDao.delete(pk);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e);				
			}
		}
		return;
		
	}


	@Override
	public void save(VideoBean vb) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			videoDao.save(vb);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e);				
			}
		}
		return;
		
	}


	@Override
	public void update(VideoBean mem) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			videoDao.save(mem);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e);				
			}
		}
		return;
		
	}

	
	@Override
	 public PageBean findCourseByPage(int currentPage, int pageSize, String hql) {
	  long count; 
	  int totalpage;
	  Session session = factory.getCurrentSession();
	  PageBean pageBean = new PageBean();
	  Transaction tx = null;
	  try {
	   tx = session.beginTransaction();
	   // 返回資料庫中的商品總數
	   count = (long) videoDao.getCountsAndPage(pageSize, hql).get(0);
	   // 計算總頁數
	   totalpage = (int) videoDao.getCountsAndPage(pageSize, hql).get(1);
	   
	   // 查詢到的當前頁面要顯示的商品
	   List<VideoBean> course = videoDao.findVideoByPage(currentPage, pageSize, hql);

	   pageBean.setCourseCount(count);
	   pageBean.setVideoBean(course);
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
	public void passOrNot(int pass, int checked, int pk,String sqlDate) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			VideoBean vb = videoDao.findById(pk);
			vb.setPass(pass);
			vb.setChecked(checked);
			vb.setChecktime(sqlDate);
			videoDao.updatPassAndChecked(vb);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	
}
