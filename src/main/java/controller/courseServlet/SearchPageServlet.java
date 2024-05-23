package controller.courseServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDao;
import dao.daolmpl.VideoDaoImpl;
import model.PageBean;
import service.ClassService;
import service.serviceimpl.ClassServiceImpl;

@WebServlet("/Course/SearchPageServlet")
public class SearchPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassService classService = new ClassServiceImpl();
		VideoDao videoDao = new VideoDaoImpl();
		
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		
		String servletPath = request.getServletPath();
		request.setAttribute("servletPath", servletPath);
		
		String curpage = request.getParameter("pageNo");
		// 為當前頁賦值
		if (!"".equals(curpage) && curpage != null) {
			currentpage = Integer.parseInt(curpage);
		}
		
		String inputValue = request.getParameter("inputValue");
		String checked = request.getParameter("checked");
		System.out.println("checked========="+checked);
		
		if(checked.equals("1")){
			String hql =  videoDao.getByInputValueHql(inputValue,checked);
			PageBean pageBean = classService.findCourseByPage(currentpage, pagesize, hql);
			request.setAttribute("pageBean", pageBean);
			RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/courseList.jsp");
			rd.forward(request, response);
			
		}else {
			
			String part = new String(inputValue.getBytes("ISO-8859-1"), "utf-8");
			String hql =  videoDao.getByInputValueHql(part,checked);
			PageBean pageBean = classService.findCourseByPage(currentpage, pagesize, hql);
			request.setAttribute("pageBean", pageBean);			
			RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/noCheckCourseList.jsp");
			rd.forward(request, response);
		}
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
