package service.serviceimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.StaffDao;
import dao.daolmpl.StaffDaoImpl;
import model.PageBean;
import model.StaffBean;
import service.StaffService;
import util.HibernateUtils;

public class StaffServiceImpl implements StaffService{
    SessionFactory factory;
    StaffDao staffDao;

    public StaffServiceImpl() {
        this.factory = HibernateUtils.getSessionFactory();
        staffDao =  new StaffDaoImpl();
    }

    @Override
    public List<StaffBean> findAll() {
        List<StaffBean> beans = null;
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            beans = staffDao.findAll();
            tx.commit();
        } catch(Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return beans;
    }

	@Override
	public void update(StaffBean staffBean) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			staffDao.update(staffBean);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public StaffBean findById(Integer id) {
		
		StaffBean staffBean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			staffBean = staffDao.findById(id);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		return staffBean;
	}

	@Override
	public void save(StaffBean sb) {

		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			staffDao.save(sb);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			} 
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public StaffBean findByMemberIdAndPassword(Integer staffId, String password) {
		Session session = factory.getCurrentSession();
		StaffBean sb = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			sb = staffDao.findByMemberIdAndPassword(staffId, password);
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return sb;
	}

	@Override
	public PageBean findStaffByPage(int currentpage, int pagesize, String hql) {
		 long count; 
		  int totalpage;
		  Session session = factory.getCurrentSession();
		  PageBean pageBean = new PageBean();
		  Transaction tx = null;
		  try {
		   tx = session.beginTransaction();
		   // 返回資料庫中的商品總數
		   count = (long) staffDao.getCountsAndPage(pagesize, hql).get(0);
		   // 計算總頁數
		   totalpage = (int) staffDao.getCountsAndPage(pagesize, hql).get(1);
		   
		   // 查詢到的當前頁面要顯示的商品
		   List<StaffBean> course = staffDao.findStaffByPage(currentpage, pagesize, hql);

		   pageBean.setCourseCount(count);
		   pageBean.setStaffBean(course);
		   pageBean.setCurrentPage(currentpage);
		   pageBean.setTotalPage(totalpage);

		   tx.commit();

		  } catch (Exception e) {
		   if (tx != null) {
		    tx.rollback();
		    e.printStackTrace();
		   }
		  }
		  return pageBean;
		
	}
		
	
	
	
    
}
