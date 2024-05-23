package controller.staffServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDao;
import dao.daolmpl.StaffDaoImpl;
import model.PageBean;
import service.StaffService;
import service.serviceimpl.StaffServiceImpl;

@WebServlet("/Staff/SearchName.do")
public class SearchName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffService staffService = new StaffServiceImpl();
		StaffDao staffDao = new StaffDaoImpl();
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		
		String servletPath = request.getServletPath();
		request.setAttribute("servletPath", servletPath);
		String curpage = request.getParameter("pageNo");
		// 為當前頁賦值
		if (!"".equals(curpage) && curpage != null) {
			currentpage = Integer.parseInt(curpage);
		}
		
		String inputName = request.getParameter("inputName");
	
			String hql =  staffDao.getByName(inputName);
			PageBean pageBean = staffService.findStaffByPage(currentpage, pagesize, hql);
			request.setAttribute("pageBean", pageBean);
			RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/backendAdminister.jsp");
			rd.forward(request, response);
			
	
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
