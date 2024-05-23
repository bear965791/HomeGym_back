package controller.orderServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrdersDao;
import dao.daolmpl.OrdersDaoImpl;
import model.PageBean;
import service.OrdersService;
import service.serviceimpl.OrdersServiceImpl;

@WebServlet("/Order/SearchMemberNameAndOrderIdPageServlet")
public class SearchMemberNameAndOrderIdPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdersService ordersService = new OrdersServiceImpl();
		OrdersDao ordersDao = new OrdersDaoImpl();
		
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
		
		String hql = ordersDao.getByInputValueHql(inputValue);
		PageBean pageBean = ordersService.findOrdersByPage(currentpage, pagesize, hql);
		request.setAttribute("pageBean", pageBean);
		RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/orderBackend.jsp");
		rd.forward(request, response);
		
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
