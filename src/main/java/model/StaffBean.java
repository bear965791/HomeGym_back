package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Staff")
public class StaffBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "staff_id")
	Integer staffId;
	@Column(name = "staff_name")
	String staffName;
	@Column(name = "staff_password")
	String staffPassword;
	@Column(name = "staff_position")
	String staffPosition;
	@Column(name = "staff_phone")
	String staffPhone;
	@Column(name = "staff_birthday")
	Date staffBirthday;
	@Column(name = "staff_check_in_day")
	Date staffCheckInDay;
	@Column(name = "staff_status")
	String staffStatus;
	
	
	
	public StaffBean() {
		super();
	}
	public StaffBean(Integer staffId, String staffName, String staffPassword, String staffPosition, String staffPhone,
			Date staffBirthday, Date staffCheckInDay, String staffStatus) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffPassword = staffPassword;
		this.staffPosition = staffPosition;
		this.staffPhone = staffPhone;
		this.staffBirthday = staffBirthday;
		this.staffCheckInDay = staffCheckInDay;
		this.staffStatus = staffStatus;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
	public String getStaffPosition() {
		return staffPosition;
	}
	public void setStaffPosition(String staffPosition) {
		this.staffPosition = staffPosition;
	}
	public String getStaffPhone() {
		return staffPhone;
	}
	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
	public Date getStaffBirthday() {
		return staffBirthday;
	}
	public void setStaffBirthday(Date staffBirthday) {
		this.staffBirthday = staffBirthday;
	}
	public Date getStaffCheckInDay() {
		return staffCheckInDay;
	}
	public void setStaffCheckInDay(Date staffCheckInDay) {
		this.staffCheckInDay = staffCheckInDay;
	}
	public String getStaffStatus() {
		return staffStatus;
	}
	public void setStaffStatus(String staffStatus) {
		this.staffStatus = staffStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
