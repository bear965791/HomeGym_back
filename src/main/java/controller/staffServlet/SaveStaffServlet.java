package controller.staffServlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.StaffBean;
import service.StaffService;
import service.serviceimpl.StaffServiceImpl;
import util.GlobalService;


@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
* 500, maxRequestSize = 1024 * 1024 * 500 * 5)


@WebServlet("/saveStaff.do")
public class SaveStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		
		String staffName = "";
		String staffPassword = "";
		String staffPosition = "";
		String staffPhone = "";
		Date staffBirthday = null;
		String staffStatus = "在職中";
		
		Collection<Part> parts = request.getParts();
		GlobalService.exploreParts(parts, request);
		
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				
				if (fldName.equals("staffName")) {
					staffName = value;
				} else if (fldName.equals("staffPassword")) {
					staffPassword = value;
				} else if (fldName.equals("staffPosition")) {
					staffPosition = value;
				} else if (fldName.equals("staffBirthday")) {
//					staffBirthday = value;
				} else if (fldName.equals("staffPhone")) {
					staffPhone = value;
				}
			}
		}
		
		String bd = request.getParameter("staffBirthday");	
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
			try {
				
				staffBirthday=sdf.parse(bd);
			} catch (ParseException e) {		
				e.printStackTrace();
			}
		
		String contextPath = request.getContextPath();
		StaffService staffService = new StaffServiceImpl();
		Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
		
		// 為了配合Hibernate的版本。
		// 要在此加密
		staffPassword = GlobalService.getMD5Endocing(
				     GlobalService.encryptString(staffPassword));
		
		StaffBean sb = new StaffBean(null,staffName,staffPassword,staffPosition,staffPhone,staffBirthday,ts,staffStatus);
		staffService.save(sb);
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/Staff/queryStaff"));
//		RequestDispatcher rd = request.getRequestDispatcher("/BackendSystem/backendAdminister.jsp");
//		rd.forward(request, response);

		
	}
}
