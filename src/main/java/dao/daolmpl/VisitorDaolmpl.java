package dao.daolmpl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.VisitorDao;
import model.VisitorBean;
import util.HibernateUtils;

public class VisitorDaolmpl implements VisitorDao {
	
	SessionFactory factory;

	public VisitorDaolmpl() {
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<VisitorBean> findVisitorByPage(int currentpage, int pagesize, String hql) {
		Session session =factory.getCurrentSession();
		List<VisitorBean> list = session.createQuery(hql, VisitorBean.class).setFirstResult((currentpage - 1) * pagesize)
				.setMaxResults(pagesize).getResultList();
		return list;
	}

	@Override
	public List<? super Integer> getCountsAndPage(int pageSize, String hql) {
		int totalPages =0;
		long count =0;
		List<? super Integer>pageInfo;
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
	public VisitorBean findById(int id) {
		VisitorBean visitor = null;
		Session session = factory.getCurrentSession();
		visitor = (VisitorBean) session.get(VisitorBean.class, id);
		return visitor;
	}
	
	@Override
	public String getByInputValueHql(String inputValue) {
		String hql;
		String text ="'"+"%"+inputValue+"%"+"'";
		hql = " From VisitorBean WHERE visitorMessage LIKE " + text;
		return hql;
	}
	
}
