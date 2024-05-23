package dao.daolmpl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.MemberDao;
import model.CoachBean;
import model.MemberBean;
import util.HibernateUtils;

public class MemberDaoImpl implements MemberDao {
	
	SessionFactory factory;
	

	

	public MemberDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}

	
	@Override
	public List<MemberBean> findMemberByPage(int currentPage, int pageSize, String hql) {
		Session session = factory.getCurrentSession();
		List<MemberBean> list = session.createQuery(hql, MemberBean.class).setFirstResult((currentPage - 1) * pageSize)
				.setMaxResults(pageSize).getResultList();
		return list;
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
	public MemberBean findById(int id) {
		MemberBean member = null;
		Session session = factory.getCurrentSession();
		member = (MemberBean) session.get(MemberBean.class, id);
		return member;
	}
	
	@Override
	public CoachBean findCoachByFk(int fk) {
		MemberBean member = null;
		CoachBean coach = null;
		Session session = factory.getCurrentSession();
		member = (MemberBean) session.get(MemberBean.class, fk);
		coach = session.get(member.getCoach().getClass(), fk);
		return coach;
	}

	
	@Override
	public String getByInputValueHql(String inputValue) {
		String hql; 
		String text = "'"+"%"+inputValue+"%"+"'";
		hql = "FROM MemberBean WHERE memberName LIKE " +text;
		return hql;
	}
	
	@Override
	public String getByInputEmailHql(String inputEmail) {
		String hql; 
		String text = "'"+"%"+inputEmail+"%"+"'";
		hql = "FROM MemberBean WHERE email LIKE " +text;
		return hql;
	}
	
	@Override
	public String getRoleHql(String role) {
		String hql;
		String part = "'" + role + "'";
		switch(role){
			case "0" :
				hql = "FROM MemberBean";
				break;
			default:
				hql = "FROM MemberBean WHERE role = " + part;
		}
		return hql;
	}




}
