package model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="coach")
public class CoachBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coach_id")
	private Integer id;
	@Column(name = "experience")
	private String experience;
	
	
	@Column(name = "certification",columnDefinition = "LONGTEXT")
	private String certification;
	@Column(name = "coach_image",columnDefinition = "LONGTEXT")
	private String coachImage;
	@Column(name = "coach_info")
	private String coachInfo;
	@Column(name = "skill")
	private String skill;
	@Column(name = "account")
	private String account;
	@Column(name = "pass")
	private String pass; 
	@Column(name = "checked")
	private	String checked; 
	@Column(name = "check_time")
	private Timestamp checkTime;
	@Column(name = "apply_time")
	private String applyTime;
	@Column(name = "suspension")
	private Integer suspension;
	

	@OneToOne(mappedBy = "coach")
	MemberBean member;
	
	@OneToMany(mappedBy = "coach", cascade = { CascadeType.PERSIST })
	private Set<VideoBean> video = new HashSet<>();


	public CoachBean() {
		super();
	}

	public Set<VideoBean> getVideo() {
		return video;
	}

	public void setVideo(Set<VideoBean> video) {
		this.video = video;
	}

	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getCoachImage() {
		return coachImage;
	}

	public void setCoachImage(String coachImage) {
		this.coachImage = coachImage;
	}

	public String getCoachInfo() {
		return coachInfo;
	}

	public void setCoachInfo(String coachInfo) {
		this.coachInfo = coachInfo;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public Timestamp getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	
	
	
	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public Integer getSuspension() {
		return suspension;
	}

	public void setSuspension(Integer suspension) {
		this.suspension = suspension;
	}

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	
	
	
}
