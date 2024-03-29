package model;

import java.util.Comparator;
import java.util.Date;

public class Activity implements Comparator {// 实现comparator接口，换句话说就是定义排序规则
	private int activityId;
	private String activityPic;
	private String activityName;
	private Date activityStartTime;
	private Date activityFinishTime;

	private Integer classifiedId;
	private String activityDuration;
	private String activityDetail;
	private Integer activityVisible;

	private Integer activityRequire;

	private String activityVideo;
	private String activityState;
	private String activityCity;
	private String activityStreet;
	private String activityApt;
	private String activityLati;
	private String activityLongi;

	private Integer activityMaxNumber;
	private Integer activityStatus;
	private Double activityFees;
	private Integer userId;
	private Date recordDate;
	private Integer activityPriority;
	public String getActivityState() {
		return activityState;
	}

	public void setActivityState(String activityState) {
		this.activityState = activityState;
	}

	public String getActivityCity() {
		return activityCity;
	}

	public void setActivityCity(String activityCity) {
		this.activityCity = activityCity;
	}

	public String getActivityStreet() {
		return activityStreet;
	}

	public void setActivityStreet(String activityStreet) {
		this.activityStreet = activityStreet;
	}

	public String getActivityApt() {
		return activityApt;
	}

	public void setActivityApt(String activityApt) {
		this.activityApt = activityApt;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityPic() {
		return activityPic;
	}

	public void setActivityPic(String activityPic) {
		this.activityPic = activityPic;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Date getActivityStartTime() {
		return activityStartTime;
	}

	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	public Date getActivityFinishTime() {
		return activityFinishTime;
	}

	public void setActivityFinishTime(Date activityFinishTime) {
		this.activityFinishTime = activityFinishTime;
	}

	public Integer getClassifiedId() {
		return classifiedId;
	}

	public void setClassifiedId(Integer classifiedId) {
		this.classifiedId = classifiedId;
	}

	public String getActivityDuration() {
		return activityDuration;
	}

	public void setActivityDuration(String activityDuration) {
		this.activityDuration = activityDuration;
	}

	public String getActivityDetail() {
		return activityDetail;
	}

	public void setActivityDetail(String activityDetail) {
		this.activityDetail = activityDetail;
	}

	public Integer getActivityVisible() {
		return activityVisible;
	}

	public void setActivityVisible(Integer activityVisible) {
		this.activityVisible = activityVisible;
	}

	public Integer getActivityRequire() {
		return activityRequire;
	}

	public void setActivityRequire(Integer activityRequire) {
		this.activityRequire = activityRequire;
	}

	public String getActivityVideo() {
		return activityVideo;
	}

	public void setActivityVideo(String activityVideo) {
		this.activityVideo = activityVideo;
	}

	public String getActivityLati() {
		return activityLati;
	}

	public void setActivityLati(String activityLati) {
		this.activityLati = activityLati;
	}

	public String getActivityLongi() {
		return activityLongi;
	}

	public void setActivityLongi(String activityLongi) {
		this.activityLongi = activityLongi;
	}

	public Integer getActivityMaxNumber() {
		return activityMaxNumber;
	}

	public void setActivityMaxNumber(Integer activityMaxNumber) {
		this.activityMaxNumber = activityMaxNumber;
	}

	public Integer getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(Integer activityStatus) {
		this.activityStatus = activityStatus;
	}

	public Double getActivityFees() {
		return activityFees;
	}

	public void setActivityFees(Double activityFees) {
		this.activityFees = activityFees;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Integer getActivityPriority() {
		return activityPriority;
	}

	public void setActivityPriority(Integer activityPriority) {
		this.activityPriority = activityPriority;
	}



	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Activity a1 = (Activity) o1;
		Activity a2 = (Activity) o2;
		if (a1.getActivityStartTime().before(a2.getActivityStartTime())) {
			return 1;
		} else {
			return 0;
		}
	}

}
