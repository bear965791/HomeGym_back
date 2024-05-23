package controller.visitorServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageBean;
import service.VisitorService;
import service.serviceimpl.visitorSviceImpl;


@WebServlet("/Visitor/VisitorProblemServlet")
public class VisitorProblem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		
		String hql = "From VisitorBean";//指定資料庫table
		
		String curpage = request.getParameter("pageNo");//得到頁數
		
		String servletPath = request.getServletPath();
		request.setAttribute("servletPath", servletPath);
		
		// 為當前頁賦值
		if (!"".equals(curpage) && curpage != null) {//?
			currentpage = Integer.parseInt(curpage);
		}
		
		VisitorService visitorSvice = new visitorSviceImpl();
		
		PageBean pageBean = visitorSvice.findVisitorByPage(currentpage, pagesize, hql);
		
		request.setAttribute("pageBean", pageBean);
		
		request.getRequestDispatcher("/BackendSystem/visitorProblem.jsp").forward(request, response);
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
