package dao;

import java.util.List;

import model.CoachBean;
import model.VideoBean;




public interface VideoDao {
	public VideoBean findById(int pk);
	public void save(VideoBean vb);
	public void update(VideoBean mem);
	public void delete(int pk) ;
	
	public List<VideoBean> findAll();

	public CoachBean findCoachByFk(int fk);
	public void updatPassAndChecked(VideoBean vb);
	List<? super Integer> getCountsAndPage(int pageSize, String hql);
	//根據頁面查詢商品
	public List<VideoBean> findVideoByPage(int currentpage, int pagesize, String hql);
	public String getByInputValueHql(String inputValue, String checked);
	public String getBypartOfBodyHql(String partOfBody);
	public String getSelectHql(String partOfBody, String num);
	
	
}
