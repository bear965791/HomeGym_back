package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class OrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "order_id")
	String orderId;
	@Column(name = "order_time")
	String orderTime;
	@Column(name = "total_amt")
	Integer totalAmt;
	@Column(name = "order_status")
	String orderStatus;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "member_id")
	MemberBean member;
	
	
	////////////////////////
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "order")
	private Set<VideoBean> course = new HashSet<VideoBean>();
	
	
	
	
	
	//////////////////////////
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "orderItem",
//	joinColumns= {
//			@JoinColumn(name="order_id",referencedColumnName = "order_id", nullable = false)
//	},
//	inverseJoinColumns = {
//			@JoinColumn(name="course_id",referencedColumnName = "course_id", nullable = false)
//	}
//			)
//	private Set<VideoBean> course = new HashSet<>();

	
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//		@JoinTable(name = "orderItem",
//			joinColumns= {
//					@JoinColumn(name="order_id",referencedColumnName = "order_id")
//			},
//			inverseJoinColumns = {
//					@JoinColumn(name="course_id",referencedColumnName = "course_id")
//			}
//		)
//	private Set<VideoBean> course = new HashSet<>();
	
	
	
	

	public Set<VideoBean> getCourse() {
		return course;
	}


	public void setCourse(Set<VideoBean> course) {
		this.course = course;
	}


	public OrderBean() {
		super();
	}


	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	

	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Integer totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	

}
