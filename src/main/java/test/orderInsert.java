package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.MemberBean;
import model.OrderBean;
import util.HibernateUtils;

public class orderInsert {

	public static void main(String[] args) {
		
		List<OrderBean> obList = new ArrayList<>();
		OrderBean ob;
		
		
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String row;
		String[] col;
		
		
		try(BufferedReader br = new BufferedReader(new FileReader("order.csv"))){
			int times = 0;
			while ((row = br.readLine()) != null) {
				if (times != 0) {
					ob = new OrderBean();
					col = row.split(",");
					
					String orderId = col[0];
					ob.setOrderId(orderId);
					
//					ob.setOrderTime(new java.sql.Timestamp(System.currentTimeMillis()));
					
					ob.setTotalAmt(Integer.parseInt(col[2]));
//					ob.setOrderStatus(col[3]);
//					int memberId = Integer.parseInt(col[4]);
//					MemberBean memberBean = session.get(MemberBean.class, memberId);
//					ob.setMember(memberBean);
//					ob.setMember(Integer.parseInt(col[4]));
					
					obList.add(ob);
					
				}
				times++;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		for(OrderBean o : obList) {
			session.persist(o);
		}
		
		tx.commit();
		session.close();
		factory.close();
		System.out.println("程式結束(Done...!!)");
		
	}

}
