package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.StaffBean;
import util.HibernateUtils;

import javax.xml.crypto.Data;

public class staffInsert {
	
	public static void main(String[] args) {
		
		StaffBean sb1 = new StaffBean();
		StaffBean sb2 = new StaffBean();
		StaffBean sb3 = new StaffBean();
		List<StaffBean> sb = Arrays.asList(sb1,sb2,sb3);
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		String row;
		String[] col;
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINESE);

		try(BufferedReader br = new BufferedReader(new FileReader("staff.csv"))){
			int i = 0;
			int times = 0;
			while((row = br.readLine()) != null) {
				if(times != 0) {
					col = row.split(",");
					
					sb.get(i).setStaffName(col[1]);
					sb.get(i).setStaffPassword(col[2]);
					sb.get(i).setStaffPosition(col[3]);
					sb.get(i).setStaffPhone(col[4]);
					sb.get(i).setStaffBirthday(format.parse(col[5]));
					sb.get(i).setStaffCheckInDay(format.parse(col[6]));
					sb.get(i).setStaffStatus(col[7]);
					i++;
				}
				times++;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		for(StaffBean v : sb) {
			session.persist(v);
		}
		tx.commit();
		session.close();
		factory.close();
		System.out.println("程式結束(Done...!!)");
		
	}

}
