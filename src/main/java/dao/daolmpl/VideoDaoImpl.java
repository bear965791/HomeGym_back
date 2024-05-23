package dao.daolmpl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.VideoDao;
import model.CoachBean;
import model.VideoBean;
import ude.RecordNotFoundException;
import util.HibernateUtils;


public class VideoDaoImpl implements VideoDao {
	
	SessionFactory factory;
	
	public VideoDaoImpl()  { 
		factory = HibernateUtils.getSessionFactory();
	}
	
	
	
	
	@Override
	public List<VideoBean> findAll() {
		Session session = factory.getCurrentSession();
        String hql = "FROM StaffBean";
        List<VideoBean> beans = session.createQuery(hql, VideoBean.class)
                .getResultList();
		return beans;
	}




	@Override
	public void save(VideoBean vb) {
		Session session = factory.getCurrentSession();
		session.save(vb);
	}

	@Override
	public void update(VideoBean vb) {
		Session session = factory.getCurrentSession();
		//單項更新
		VideoBean vb1 = session.get(VideoBean.class, vb.getVideoId());
		vb.setPrice(vb1.getPrice());
        session.merge(vb);
	}	
	

	
	@Override
	public void delete(int videoId) {
		Session session = factory.getCurrentSession();
		VideoBean video01 = findById(videoId);
		if (video01 == null ) {
			throw new RecordNotFoundException("要刪除的紀錄不存在: 主鍵值為: " + videoId);
		} else {
			session.delete(video01);  
		}
	}

	
	@Override
	public VideoBean findById(int videoId) {
		VideoBean video = null;
		Session session = factory.getCurrentSession();
		Integer videopk = Integer.valueOf(videoId);
		video = (VideoBean) session.get(VideoBean.class, videopk);
		return video;
	}


	@Override
	public CoachBean findCoachByFk(int fk) {
		VideoBean video = null;
		CoachBean coach = null;
		Session session = factory.getCurrentSession();
		video = (VideoBean) session.get(VideoBean.class, fk);
		coach = session.get(video.getCoach().getClass(), fk);
		return coach;
	}


	@Override
	public String getBypartOfBodyHql(String partOfBody) {
		String hql;
		String part = "'" + partOfBody + "'";
		switch(partOfBody){
			case "0" :
				hql = "FROM VideoBean WHERE checked = 0";
				break;
			default:
				hql = "FROM VideoBean WHERE checked = 0 and partOfBody = " + part;
		}
		return hql;
	}



	@Override
	 public String getSelectHql(String partOfBody, String num) {
	  String selectHql;
	  String part = "'" + partOfBody + "'";
	 
	  if(num.equals("2")) {
	   
	   if(partOfBody.equals("0")) {
	    selectHql = "FROM VideoBean WHERE checked = 1";
	    
	   }else {
	    selectHql = "FROM VideoBean WHERE checked = 1 AND partOfBody = " + part;
	   }
	   
	  }else if(partOfBody.equals("0")){
	   selectHql = "FROM VideoBean WHERE checked = 1 AND  pass = " + num;
	  }else {
	   selectHql = "FROM VideoBean WHERE checked = 1 AND partOfBody = " + part + " AND pass = " + num;
	   
	  }
	  return selectHql;
	 }

	

	
	@Override
	 public List<? super Integer> getCountsAndPage(int pageSize, String hql) {
	  int totalPages = 0;
	  long count = 0; 
	  List<? super Integer> pageInfo;
	  String countHql = "SELECT count(*) " + hql;
	  
	  Session session = factory.getCurrentSession();

	  List<Long> list = session.createQuery(countHql, Long.class).getResultList();
	  
	  if (list.size() > 0) {
	   count = list.get(0);
	  }
	  
	  totalPages = (int) (Math.ceil(count / (double) pageSize));
	  
	  pageInfo = Arrays.asList(count,totalPages);
	  
	  return pageInfo;
	 }

	@Override
	public List<VideoBean> findVideoByPage(int currentPage, int pageSize, String hql) {
		Session session = factory.getCurrentSession();
		List<VideoBean> list = session.createQuery(hql, VideoBean.class).setFirstResult((currentPage - 1) * pageSize)
				.setMaxResults(pageSize).getResultList();	
		return list;
	}



	@Override
	public void updatPassAndChecked(VideoBean vb) {
		
		Session session = factory.getCurrentSession();
		VideoBean vb0 = session.get(VideoBean.class, vb.getVideoId());

		vb.setPass(vb0.getPass());
		vb.setChecked(vb0.getChecked());
		session.evict(vb0);
		session.merge(vb);
	}

	@Override
	public String getByInputValueHql(String inputValue, String checked) {
		String hql; 
		String text = "'"+"%"+inputValue+"%"+"'";
		hql = "FROM VideoBean WHERE checked = "+ checked + " AND  name LIKE " +text + " OR "+" checked = "+ checked  + " AND videoId LIKE " + text;
		return hql;
	}




}
