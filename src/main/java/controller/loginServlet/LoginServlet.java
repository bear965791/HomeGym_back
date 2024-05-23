package controller.loginServlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.mysql.cj.log.Log;

import lombok.extern.slf4j.Slf4j;
import model.LogoutBean;
import model.StaffBean;
import service.StaffService;
import service.serviceimpl.StaffServiceImpl;
import util.GlobalService;

@Slf4j
@WebServlet("/loginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
    }
    
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession();
			
			// 定義存放錯誤訊息的Map物件
			Map<String, String> messageMap = new HashMap<String, String>();
			// 將messageMap放入request物件內，識別字串為 "messageKey"
			request.setAttribute("messageKey", messageMap);
			
			//讀取使用者輸入
			String staffIdStr = request.getParameter("staffId");
			String password = request.getParameter("staffPassword");
			
			//檢查輸入資料
			varifyInput(staffIdStr, password, messageMap, request, response);
			
			// 如果 messageMap 不是空的，表示有錯誤，交棒給login.jsp
			if (!messageMap.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				return;
			}
			
			// 將MemberServiceImpl類別new為物件，存放物件參考的變數為 loginService
			StaffService staffService  = new StaffServiceImpl();
			
			// 將密碼加密兩次，以便與存放在表格內的密碼比對
			String encryptPassword = GlobalService.getMD5Endocing(GlobalService.encryptString(password));
			
			StaffBean sb = staffService.findByMemberIdAndPassword(Integer.parseInt(staffIdStr.trim()), encryptPassword);
			
			//TODO 改用ENUM判斷
			if(sb == null) {
				messageMap.put("loginFail", "該帳號不存在或密碼錯誤");
			}else if (sb.getStaffStatus().equals("已離職")) {
				messageMap.put("loginFail", "本員工已離職");
			}else {
				// OK, 登入成功, 將mb物件放入Session範圍內，識別字串為"LoginOK"
				session.setAttribute("LoginOK", sb);
				// 建立登出所需的LogoutBean物件
				LogoutBean logoutBean = new LogoutBean(session);
				session.setAttribute("logoutBean", logoutBean);
//				String staffIdStr1 = staffId.toString();
				processCookies(request, response, staffIdStr, password);
			}
			
			//依照 Business Logic 運算結果來挑選適當的畫面
			//如果 messageMap 是空的，表示沒有任何錯誤，交棒給下一棒
			if (messageMap.isEmpty()) {
					String contextPath = request.getContextPath();
					response.sendRedirect(response.encodeRedirectURL(contextPath + "/Course/checkedCoursePage"));
			} else {
				// 如果errorMsgMap不是空的，表示有錯誤，交棒給login.jsp
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (Exception e) {
			log.error("loginServlet.do:",e);
		}
	}
	
	private void varifyInput(String staffIdStr, String password,Map<String, String> messageMap,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//檢查使用者輸入資料
		if(staffIdStr == null){
			messageMap.put("accountEmpty", "帳號欄必須輸入");
		}
		if (password == null || password.trim().length() == 0) {
			messageMap.put("passwordEmpty", "密碼欄必須輸入");
		}

	}
	
	
	private void processCookies(HttpServletRequest request, HttpServletResponse response, 
			String userId, String password) {
	// **********Remember Me****************************
		Cookie cookieUser = null;
		Cookie cookiePassword = null;
		Cookie cookieRememberMe = null;
	
		cookieUser = new Cookie("user", userId);
		cookieUser.setMaxAge(0); // MaxAge==0 表示要請瀏覽器刪除此Cookie
		cookieUser.setPath(request.getContextPath());
		
//		String encodePassword = GlobalService.encryptString(password);
//		cookiePassword = new Cookie("password", encodePassword);
		cookiePassword = new Cookie("password", password);
		cookiePassword.setMaxAge(0);
		cookiePassword.setPath(request.getContextPath());
		
		cookieRememberMe = new Cookie("rm", "true");
		cookieRememberMe.setMaxAge(0);
		cookieRememberMe.setPath(request.getContextPath());
		
		response.addCookie(cookieUser);
		response.addCookie(cookiePassword);
		response.addCookie(cookieRememberMe);
	}

}
