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


//查詢功能
@WebServlet("/Course/DoubleCategoryPage.do")
public class DoubleCategoryPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request,response);
		//傳入挑選的選項去搜尋
				ClassService classService = new ClassServiceImpl();	
				VideoDao videoDao = new VideoDaoImpl();
				
				int currentpage = 1;// 默認的當前頁
				int pagesize = 5;// 每頁顯示的商品數
				String curpage = request.getParameter("pageNo");
				
				// 為當前頁賦值
				if (!"".equals(curpage) && curpage != null) {
					currentpage = Integer.parseInt(curpage);
				}
				
				String status = request.getParameter("status");
				String partOfBody = request.getParameter("partOfBody");
				
				String hql =  videoDao.getSelectHql(partOfBody, status);
				PageBean pageBean = classService.findCourseByPage(currentpage, pagesize, hql);
				
				request.setAttribute("pageBean", pageBean);
				
				RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/courseList.jsp");
				rd.forward(request, response);
				return;
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);

	}

}
