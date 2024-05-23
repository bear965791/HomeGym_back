package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="visitor")
public class VisitorBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "visitor_id")
		private Integer visitorId;
		@Column(name = "visitor_email")
		private String visitorMail;//訪客信箱
		@Column(name = "visitor_name")
		private String visitorName;//訪客名字
		@Column(name = "visitor_message")
		private String visitorMessage;//訪客問題
		@Column(name = "visitor_time")
		private String visitorTime;
		
		
		public String getVisitorMail() {
			return visitorMail;
		}
		public void setVisitorMail(String visitorMail) {
			this.visitorMail = visitorMail;
		}
		public String getVisitorName() {
			return visitorName;
		}
		public void setVisitorName(String visitorName) {
			this.visitorName = visitorName;
		}
		public String getVisitorMessage() {
			return visitorMessage;
		}
		public void setVisitorMessage(String visitorMessage) {
			this.visitorMessage = visitorMessage;
		}
		
		
		
		
		public String getVisitorTime() {
			return visitorTime;
		}
		public void setVisitorTime(String visitorTime) {
			this.visitorTime = visitorTime;
		}
		public VisitorBean(String visitorMail, String visitorName, String visitorMessage, String visitorTime) {
			super();
			this.visitorMail = visitorMail;
			this.visitorName = visitorName;
			this.visitorMessage = visitorMessage;
			this.visitorTime = visitorTime;
		}
		public VisitorBean() {
			
		}
		
		
		
		
		
		
}
