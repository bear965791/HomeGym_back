package controller.memberServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.daolmpl.MemberDaoImpl;
import model.PageBean;
import service.MemberService;
import service.serviceimpl.MemberServiceImpl;

@WebServlet("/Member/EmailSearchPageServlet")
public class EmailSearchPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDao memberDao = new MemberDaoImpl();
		MemberService memberService = new MemberServiceImpl();
		
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		
		String servletPath = request.getServletPath();
		request.setAttribute("servletPath", servletPath);
		
		String curpage = request.getParameter("pageNo");
		// 為當前頁賦值
		if (!"".equals(curpage) && curpage != null) {
			currentpage = Integer.parseInt(curpage);
		}
		
		String inputEmail = request.getParameter("inputEmail");

			String hql =  memberDao.getByInputEmailHql(inputEmail);
			PageBean pageBean = memberService.findMemberByPage(currentpage, pagesize, hql);
			request.setAttribute("pageBean", pageBean);
			RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/checkingCoachingList.jsp");
			rd.forward(request, response);
		
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
