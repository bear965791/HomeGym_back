package service;

import java.sql.Timestamp;

import model.CoachBean;

public interface CoachService {
	
	public CoachBean findByFk(int fk);

	public void passOrNot(String pass, String checked, int id,Timestamp sqlDate);
}
