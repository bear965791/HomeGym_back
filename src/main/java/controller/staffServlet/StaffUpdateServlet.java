package controller.staffServlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StaffBean;
import service.StaffService;
import service.serviceimpl.StaffServiceImpl;
import util.GlobalService;

@WebServlet("/staff/staffUpdate.do")
public class StaffUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession hsession = request.getSession();
//		Map<String,String> errorMsg = new HashMap<>();
//		request.setAttribute("error", errorMsg);
		String modify = request.getParameter("finalDecision"); //讀取提示訊息
		String sid = request.getParameter("staffId");
		int staffId = Integer.parseInt(sid);
//		if (sid.trim().length() >  0) {
//			staffId = Integer.parseInt(sid);
//		}
		StaffService staffService =new StaffServiceImpl();
		
//		MemberService memberService = new MemberServiceImpl();
//		if(modify.equalsIgnoreCase("DELETE")){
//			try {
//				memberService.delete(id);
//				hsession.setAttribute("modify", "刪除成功");
//			}catch(Exception e){
//				hsession.setAttribute("modify", "刪除時發生異常");
//			}
//			String url = request.getContextPath()+"/ch01/queryMember.do";
//			String newurl = response.encodeRedirectURL(url);
//			response.sendRedirect(newurl);
//			
//		}else 
			
			
			if(modify.equalsIgnoreCase("UPDATE")){
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
//				String staffId = request.getParameter("staffId");
				String staffName = request.getParameter("staffName");
				String staffPassword = request.getParameter("staffPassword");
				
//				String encryptPassword = GlobalService.getMD5Endocing(GlobalService.encryptString(staffPassword));
				
				String staffPosition = request.getParameter("staffPosition");
				String staffPhone = request.getParameter("staffPhone");
				
//				String strStaffBirthday = request.getParameter("staffBirthday");
//				String strStaffCheckInDay = request.getParameter("staffCheckInDay");
				Date staffBirthday = null;
				Date staffCheckInDay = null;
				
				String  bd= request.getParameter("staffBirthday");	//暫存staffBirthday
			    String cid = request.getParameter("staffCheckInDay");//暫存staffCheckInDay
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
					try {
						staffBirthday=sdf.parse(bd);
						staffCheckInDay=sdf.parse(cid);
					} catch (Exception e) {		
						e.printStackTrace();
					}
				
				
				String staffStatus = request.getParameter("staffStatus");
				//檢查輸入的資料
//				if (staffName == null || staffName.trim().length() == 0) {
//					errorMsg.put("name", "姓名欄不能空白");
//				}			
//				if (staffPhone == null || staffPhone.trim().length() == 0) {
//					errorMsg.put("pswd", "密碼欄不能空白");
//				}
				//如果輸入資料都正確,進行修改動作
//				if (!errorMsg.isEmpty()) {
//					RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/backendAdministerUpdate.jsp");
//					rd.forward(request, response);
//					return;
//			}
			StaffBean sb = new StaffBean(staffId,staffName,staffPassword,staffPosition,staffPhone,staffBirthday,staffCheckInDay,staffStatus);
			try {
				hsession.setAttribute("modify", "修改成功");
			staffService.update(sb);
			}catch(Exception e){
				hsession.setAttribute("modify", "修改時發生異常");
			}
			String url = request.getContextPath()+"/Staff/queryStaff";
//			String url = request.getContextPath()+"/BackendSystem/backendAdminister.jsp";
			String newurl = response.encodeRedirectURL(url);
			response.sendRedirect(newurl);
		}
	}
	
	

}
