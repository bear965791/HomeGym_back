package model;

import java.io.Serializable;
import java.sql.Clob;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class VideoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Integer videoId;
	@Column(name = "course_name")
	private String name;	//課程名
	@Column(name = "course_info")
	private String videoInfo;	//課程資訊
//	@Column(name = "category")
//	private String category; //課程類別
	@Column(name = "part_of_body")
	private String partOfBody; //不確定會用數字還是字串來設定  //運動部位
	@Column(name = "course_image",columnDefinition = "LONGTEXT")
	private String videoImage;	//影片圖片
	@Column(name = "mime_type")
	private String mimeType;   // /dmot/src/main/java/_03_listBooks/service/impl/BookServiceImpl.java
	@Column(name = "upload_time")
	private String time;	//上傳時間
	@Column(name = "price")
	private Integer price; //Integer or Double 	//課程價格
//	@Column(name = "")
//	private String coach; //放影片上傳者
	@Column(name = "equipment")
	private String equipment; //器材
	@Column(name = "level")
	private String level; //適合的層級
	@Column(name = "pass")
	private Integer pass; //課程是否審核成功
	@Column(name = "checked")
	private	Integer checked; //審核狀態（未審核/已審核）
	@Column(name = "check_time")
	private String checktime;
	@Column(name = "course_path")
	private String videoPath;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "coach_id")
	CoachBean coach;
	/////////
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "order_item",
		joinColumns= {
				@JoinColumn(name="course_id",referencedColumnName = "course_id")
		},
		inverseJoinColumns = {
				@JoinColumn(name="order_id",referencedColumnName = "order_id")
		}
	)
	private Set<OrderBean> order = new HashSet<>();
	
	
	
	
	

	public VideoBean() {
		super();
	}


	


	public Set<OrderBean> getOrder() {
		return order;
	}


	public void setOrder(Set<OrderBean> order) {
		this.order = order;
	}


	public CoachBean getCoach() {
		return coach;
	}



	public void setCoach(CoachBean coach) {
		this.coach = coach;
	}



	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVideoInfo() {
		return videoInfo;
	}

	public void setVideoInfo(String videoInfo) {
		this.videoInfo = videoInfo;
	}


	public String getPartOfBody() {
		return partOfBody;
	}

	public void setPartOfBody(String partOfBody) {
		this.partOfBody = partOfBody;
	}

	public String getVideoImage() {
		return videoImage;
	}

	public void setVideoImage(String videoImage) {
		this.videoImage = videoImage;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	

	public String getTime() {
		return time;
	}





	public void setTime(String time) {
		this.time = time;
	}





	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getPass() {
		return pass;
	}

	public void setPass(Integer pass) {
		this.pass = pass;
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	

	public String getChecktime() {
		return checktime;
	}





	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}





	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
