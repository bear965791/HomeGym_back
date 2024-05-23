package service;

import java.sql.Date;

import model.PageBean;
import model.VideoBean;


public interface ClassService {
	public VideoBean findById(int pk);
	void delete(int pk) ;
	public void save(VideoBean vb);
	public void update(VideoBean mem);
	public void passOrNot(int pass, int checked, int pk,String sqlDate);
	public PageBean findCourseByPage(int currentPage, int pageSize, String hql);
}
