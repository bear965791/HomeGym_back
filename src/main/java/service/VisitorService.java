package service;

import model.PageBean;

public interface VisitorService {
	public PageBean findVisitorByPage(int currentPage, int pageSize, String hql);
	
	
}

