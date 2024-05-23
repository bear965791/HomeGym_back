package service.serviceimpl;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CoachDao;
import dao.daolmpl.CoachDaoImpl;
import model.CoachBean;
import service.CoachService;
import util.HibernateUtils;

public class CoachServiceImpl implements CoachService {

	
	SessionFactory factory;
	CoachDao coachDao;
	
	public CoachServiceImpl() {
		factory = HibernateUtils.getSessionFactory();
		coachDao = new CoachDaoImpl();
	}
	
	@Override
	public CoachBean findByFk(int fk) {
		Session session = factory.getCurrentSession();
		CoachBean bean = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = coachDao.findByFk(fk);
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
	public void passOrNot(String pass, String checked, int id,Timestamp sqlDate) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			CoachBean coach = coachDao.findByFk(id);
			coach.setPass(pass);
			coach.setChecked(checked);
			coach.setCheckTime(sqlDate);
			if(pass.equals("1")) {
				coach.getMember().setRole("ROLE_COACH");
			}
			coachDao.updatPassAndChecked(coach);
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
