package controller.memberServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CoachBean;
import model.MemberBean;
import service.MemberService;
import service.serviceimpl.MemberServiceImpl;
import util.GlobalService;


@WebServlet("/CoachDetalPageServlet")
public class CoachDetalPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService memberService = new MemberServiceImpl();
		
		String memberId = request.getParameter("memberId");
		MemberBean mb = memberService.findById(Integer.parseInt(memberId));
		CoachBean coachBean = mb.getCoach();
	
		
		try {
			String  stringCoachInfo = coachBean.getCoachInfo();
			request.setAttribute("StringCoachInfo", stringCoachInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("CoachBean",coachBean);
		
		if(coachBean.getChecked().equals("0")) {
			RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/checkingCoachingDetail.jsp");	
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/checkedCoachingDetail.jsp");
			rd.forward(request, response);
		}
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
