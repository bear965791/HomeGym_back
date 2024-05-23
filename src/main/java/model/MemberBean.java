package model;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="`member`")
public class MemberBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="member_id")
	private Integer memberId;
	@Column(name = "password")
	private String memberPassword;
	@Column(name = "member_name")
	private String memberName;
	@Column(name= "email")
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name = "birthday")
	private Date birthday;
	@Column(name="role")
	private String role;
	@Column(name = "member_image")
	private byte[] memberPicture;
	@Column(name = "create_time")
	private Timestamp registerTime;
	@Column(name = "status")
	private Integer status;
	@Column(name = "code")
	private String code;
	@Column(name = "mine_type")
	private String minetype;
		
	@Transient
	private String image;
	
	@OneToOne(cascade =CascadeType.PERSIST)
	@JoinColumn(name = "coach_id")
	CoachBean coach;
//	
//	
	@OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
	private Set<OrderBean> order = new HashSet<>();
	
	

	


	
	
	public MemberBean(Integer memberId, String memberPassword, String memberName, String email, String phone, Date birthday,
		String role, byte[] memberPicture, Timestamp registerTime, Integer status, String code, String minetype,
		String image, CoachBean coach, Set<OrderBean> order) {
	super();
	this.memberId = memberId;
	this.memberPassword = memberPassword;
	this.memberName = memberName;
	this.email = email;
	this.phone = phone;
	this.birthday = birthday;
	this.role = role;
	this.memberPicture = memberPicture;
	this.registerTime = registerTime;
	this.status = status;
	this.code = code;
	this.minetype = minetype;
	this.image = image;
	this.coach = coach;
	this.order = order;
}



	public MemberBean() {
		super();
	}

	
	


	public String getMinetype() {
		return minetype;
	}



	public void setMinetype(String minetype) {
		this.minetype = minetype;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public Integer getMemberId() {
		return memberId;
	}

	public Set<OrderBean> getOrder() {
		return order;
	}

	public void setOrder(Set<OrderBean> order) {
		this.order = order;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public byte[] getMemberPicture() {
		return memberPicture;
	}

	public void setMemberPicture(byte[] memberPicture) {
		this.memberPicture = memberPicture;
	}

	public Timestamp getRegisterTime() {
		
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public CoachBean getCoach() {
		return coach;
	}

	public void setCoach(CoachBean coach) {
		this.coach = coach;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getMine_type() {
		return minetype;
	}



	public void setMine_type(String mine_type) {
		this.minetype = minetype;
	}

	
	
	
	
	
}
