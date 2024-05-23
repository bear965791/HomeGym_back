package controller.visitorServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitorDao;
import dao.daolmpl.VisitorDaolmpl;
import model.PageBean;
import service.VisitorService;
import service.serviceimpl.visitorSviceImpl;


@WebServlet("/Visitor/SearchMessagePageServlet")
public class SearchMessagePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		VisitorService visitorService = new visitorSviceImpl();
		VisitorDao visitorDao = new VisitorDaolmpl(); 
		
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
		
		
		String hql =  visitorDao.getByInputValueHql(inputValue);
		PageBean pageBean = visitorService.findVisitorByPage(currentpage, pagesize, hql);
		request.setAttribute("pageBean", pageBean);
		RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/visitorProblem.jsp");
		rd.forward(request, response);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
