package controller.staffServlet;

import model.StaffBean;
import service.StaffService;
import service.serviceimpl.StaffServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Staff/QueryAllStaffServlet")
public class QueryAllStaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StaffService memberService = new StaffServiceImpl();
        List<StaffBean> list = memberService.findAll();

        request.setAttribute("staff", list);
        RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/backendAdminister.jsp");
        rd.forward(request, response);
        return;
    }



}
