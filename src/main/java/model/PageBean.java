package model;

import java.util.List;


public class PageBean {
		
		private Integer currentPage;//當前頁
		private Integer totalPage;//總頁數
		private Integer pageSize;//ㄧ頁放幾項商品
		private Long courseCount;//商品個數
		private List<VideoBean> videoBean;//商品物件
		private List<MemberBean> memberBean;
		private List<StaffBean> staffBean;
		private List<OrderBean> orderBean;
		private List<VisitorBean> visitorBean;
		
		
		
		
		
		public List<VisitorBean> getVisitorBean() {
			return visitorBean;
		}
		public void setVisitorBean(List<VisitorBean> visitorBean) {
			this.visitorBean = visitorBean;
		}
		public List<OrderBean> getOrderBean() {
			return orderBean;
		}
		public void setOrderBean(List<OrderBean> orderBean) {
			this.orderBean = orderBean;
		}
		public Integer getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(Integer currentPage) {
			this.currentPage = currentPage;
		}
		public Integer getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(Integer totalPage) {
			this.totalPage = totalPage;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		public Long getCourseCount() {
			return courseCount;
		}
		public void setCourseCount(Long courseCount) {
			this.courseCount = courseCount;
		}
		public List<VideoBean> getVideoBean() {
			return videoBean;
		}
		public void setVideoBean(List<VideoBean> videoBean) {
			this.videoBean = videoBean;
		}
		public List<MemberBean> getMemberBean() {
			return memberBean;
		}
		public void setMemberBean(List<MemberBean> memberBean) {
			this.memberBean = memberBean;
		}
		public List<StaffBean> getStaffBean() {
			return staffBean;
		}
		public void setStaffBean(List<StaffBean> staffBean) {
			this.staffBean = staffBean;
		}
		
		
		
		
}
