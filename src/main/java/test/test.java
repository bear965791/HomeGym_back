package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.OrderBean;
import model.VideoBean;
import util.HibernateUtils;

public class test {

    public static void main(String[] args) {
    	
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	
    	
    	Session session = factory.openSession();
    	String hql = "FROM OrderBean";
    	List<OrderBean> list = session.createQuery(hql, OrderBean.class).getResultList();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for(OrderBean ob: list) {
				for(VideoBean vb : ob.getCourse()) {
					System.out.println("=========="+vb);
					System.out.println("=========="+vb.getName());
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
		
	
    	
    	
    	
    	
    	
//        System.out.println("fff");
//        
////        VideoDao vd;
////        CoachBean coachBean;
//        
////        VideoDao vd = new VideoDaoImpl();
////        String name = vd.findCoachByFk(2).getSkill();
////        System.out.println(name);
//        
//        MemberDao memberDao = new MemberDaoImpl();
//        
//        String name = memberDao.findCoachByFk(2).getSkill();
//        System.out.println(name);
//        
//        
//        
    }
}
