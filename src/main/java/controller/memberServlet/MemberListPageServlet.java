package controller.memberServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageBean;
import service.MemberService;
import service.serviceimpl.MemberServiceImpl;


@WebServlet("/Member/MemberListPageServlet")
public class MemberListPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		
		String hql = "From MemberBean";
		
		String curpage = request.getParameter("pageNo");
		
		String servletPath = request.getServletPath();
		request.setAttribute("servletPath", servletPath);
		
		// 為當前頁賦值
		if (!"".equals(curpage) && curpage != null) {
			currentpage = Integer.parseInt(curpage);
		}
		
		MemberService memberService = new MemberServiceImpl();
		
		PageBean pageBean = memberService.findMemberByPage(currentpage, pagesize, hql);
		
		request.setAttribute("pageBean", pageBean);
		
		request.getRequestDispatcher("/BackendSystem/memberBackend.jsp").forward(request, response);
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
