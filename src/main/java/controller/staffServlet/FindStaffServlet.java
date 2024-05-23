package controller.staffServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StaffBean;
import service.StaffService;
import service.serviceimpl.StaffServiceImpl;

@WebServlet("/Staff/findStaff")
public class FindStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String key = request.getParameter("key");
		int id = Integer.parseInt(key);
		StaffService staffService = new StaffServiceImpl();
		StaffBean sb = staffService.findById(id);
		request.setAttribute("sb", sb);
		RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/backendAdministerUpdate.jsp");
		rd.forward(request, response);
		return;
		
	}
}
