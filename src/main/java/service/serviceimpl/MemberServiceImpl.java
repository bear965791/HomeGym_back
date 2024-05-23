package service.serviceimpl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.MemberDao;
import dao.VideoDao;
import dao.daolmpl.MemberDaoImpl;
import model.CoachBean;
import model.MemberBean;
import model.PageBean;
import service.MemberService;
import util.HibernateUtils;

public class MemberServiceImpl implements MemberService {
	
	SessionFactory factory;
	MemberDao memberDao;
	VideoDao videoDao;
	
	public MemberServiceImpl() {
		factory = HibernateUtils.getSessionFactory();
		memberDao = new MemberDaoImpl();
	}


	@Override
	public PageBean findMemberByPage(int currentPage, int pageSize, String hql) {
		 long count; 
		  int totalpage;
		  Session session = factory.getCurrentSession();
		  PageBean pageBean = new PageBean();
		  Transaction tx = null;
		  try {
		   tx = session.beginTransaction();
		   // 返回資料庫中的商品總數
		   count = (long) memberDao.getCountsAndPage(pageSize, hql).get(0);
		   // 計算總頁數
		   totalpage = (int) memberDao.getCountsAndPage(pageSize, hql).get(1);
		   
		   // 查詢到的當前頁面要顯示的商品
		   List<MemberBean> course = memberDao.findMemberByPage(currentPage, pageSize, hql);
		   System.out.println("出現出現出現出現出現出現出現出現出現出現出現出現出現出現出現");
		   for(MemberBean mb:course) {
			   if(mb.getMemberPicture()!=null) {
				   String mimeType = mb.getMinetype();
				   String baseString = Base64.getEncoder().encodeToString(mb.getMemberPicture());
				   mb.setImage("data:"+mimeType+";base64,"+baseString);
			   }
		   }
		   
		   
		   
//		   data:image/png;base64,/2121213dkfnvaakmkmcdmvllsmclkfuih
		   
		   //////
//		   Iterator iterator = course.iterator();
//		   MemberBean memberBean = (MemberBean) iterator.next();
//		   Date date = memberBean.getBirthday();
//		   SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//		   String dateBufferString = format.format(date);
//		   java.util.Date dateBuffer;
//		   dateBuffer = format.parse(dateBufferString);
//		   memberBean.setBirthday(dateBuffer);

		   pageBean.setCourseCount(count);
		   pageBean.setMemberBean(course);
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
	public  MemberBean findById(int id) {
		Session session = factory.getCurrentSession();
		MemberBean bean = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = memberDao.findById(id);
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
	public CoachBean findCoachByFk(int fk) {
		Session session = factory.getCurrentSession();
		CoachBean bean = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = memberDao.findCoachByFk(fk);
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
