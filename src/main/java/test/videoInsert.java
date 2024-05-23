package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.sql.rowset.serial.SerialClob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.MemberBean;
import model.OrderBean;
import model.VideoBean;
import util.HibernateUtils;

public class videoInsert {

	public static void main(String[] args) {

		List<VideoBean> vbList = new ArrayList<>();
		VideoBean vb;
//		CoachBean cb;
		

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String row;
		String[] col;
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINESE);

		try (BufferedReader br = new BufferedReader(new FileReader("video.csv"))) {
			int times = 0;
			while ((row = br.readLine()) != null) {
				if (times != 0) {
					vb = new VideoBean();
//					cb = new CoachBean();
					col = row.split(",");
					
					
					
					vb.setName(col[1]);
					vb.setVideoInfo(col[2]);
//					vb.setCategory(col[3]);
					vb.setPartOfBody(col[4]);
//					try {
//						
//						vb.setTime(new Date(format.parse(col[7]).getTime()));
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
					vb.setPrice(Integer.parseInt(col[8]));					
					
//					vb.setCoach(col[9]);
					vb.setEquipment(col[10]);
					vb.setLevel(col[11]);
					vb.setPass(Integer.parseInt(col[12]));
					vb.setChecked(Integer.parseInt(col[13]));
					vbList.add(vb);
				}
				times++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(VideoBean v : vbList) {
			session.persist(v);
		}
		tx.commit();
		session.close();
		factory.close();
		System.out.println("程式結束(Done...!!)");
	}
}
