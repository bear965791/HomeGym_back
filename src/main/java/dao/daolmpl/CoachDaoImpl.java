package dao.daolmpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.CoachDao;
import model.CoachBean;
import util.HibernateUtils;

public class CoachDaoImpl implements CoachDao {
	
	SessionFactory factory;
	

	

	public CoachDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}


	@Override
	public CoachBean findByFk(int fk) {
		System.out.println(fk);
		CoachBean coach = null;
		Session session = factory.getCurrentSession();
		coach = (CoachBean) session.get(CoachBean.class, fk);
		return coach;
	}
	
	@Override
	public void updatPassAndChecked(CoachBean cb) {
		
		Session session = factory.getCurrentSession();
		CoachBean cb0 = session.get(CoachBean.class, cb.getId());
		cb.setPass(cb0.getPass());
		cb.setChecked(cb0.getChecked());
		cb.getMember().setRole(cb0.getMember().getRole());
		session.evict(cb0);
		session.merge(cb);
	}



}
