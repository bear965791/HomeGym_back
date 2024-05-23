package controller.courseServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageBean;
import service.ClassService;
import service.serviceimpl.ClassServiceImpl;

@WebServlet("/Course/checkedCoursePage")
public class CheckedPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		String hql = "From VideoBean v WHERE v.checked = 1";
		String curpage = request.getParameter("pageNo");
		// 為當前頁賦值
		if (!"".equals(curpage) && curpage != null) {
			currentpage = Integer.parseInt(curpage);
		}
		ClassService classService = new ClassServiceImpl();
		// 根據頁面資訊查找商品
		PageBean pageBean = classService.findCourseByPage(currentpage, pagesize, hql);
		// 將商品儲存到request
		request.setAttribute("pageBean", pageBean);
		// 轉發頁面到商品瀏覽頁面
		request.getRequestDispatcher("/BackendSystem/courseList.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
