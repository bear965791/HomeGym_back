package controller.staffServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageBean;
import service.StaffService;
import service.serviceimpl.StaffServiceImpl;

@WebServlet("/Staff/queryStaff")
public class CheckedPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		String hql = "From StaffBean";
		String curpage = request.getParameter("pageNo");
		// 為當前頁賦值
		if (!"".equals(curpage) && curpage != null) {
			currentpage = Integer.parseInt(curpage);
		}
		StaffService staffService = new StaffServiceImpl();
		// 根據頁面資訊查找商品
		PageBean pageBean = staffService.findStaffByPage(currentpage, pagesize, hql);
		// 將商品儲存到request
		request.setAttribute("pageBean", pageBean);
		// 轉發頁面到商品瀏覽頁面
		request.getRequestDispatcher("/BackendSystem/backendAdminister.jsp").forward(request, response);
		return;
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
