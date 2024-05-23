package model;


import javax.servlet.http.HttpSession;


public class LogoutBean {
	
	HttpSession session;

	public LogoutBean(HttpSession session) {
		super();
		this.session = session;
	}

	public LogoutBean() {
		super();
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	public Integer getLogout() {
		
		session.invalidate();
		return 0;
	}
	
	
	

}
