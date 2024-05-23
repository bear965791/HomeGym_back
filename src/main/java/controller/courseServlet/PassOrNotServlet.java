package controller.courseServlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClassService;
import service.serviceimpl.ClassServiceImpl;


@WebServlet("/Course/notCheckCoursePage/checking")
public class PassOrNotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int checked = 1;
		int pass = Integer.parseInt(request.getParameter("passOrNot"));
		int pk = Integer.parseInt(request.getParameter("videoId"));
		Date date = new Date();
		String sqlDate = new java.sql.Date(date.getTime()).toString();
		ClassService classService = new ClassServiceImpl();
		classService.passOrNot(pass, checked, pk, sqlDate);
	
		String contextPath = request.getContextPath();
		response.encodeRedirectURL(contextPath + "/Course/checkedCoursePage");
		
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/Course/checkedCoursePage"));
		
		
		return;
		
	}

}
