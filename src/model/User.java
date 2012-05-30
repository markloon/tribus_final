package model;

import java.io.Serializable;

public class User implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1523016625960386020L;
	
	
	private int userId;	
	private String userAlias;
	private String userEmail;	
	private String userPic;	
	private String userPassword;		
	private Integer userStatus;
	private Integer userVerifycode;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAlias() {
		return userAlias;
	}
	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String email) {
		this.userEmail = email;
	}
	public String getUserPic() {
		return userPic;
	}
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	public Integer getUserVerifycode() {
		return userVerifycode;
	}
	public void setUserVerifycode(Integer userVerifycode) {
		this.userVerifycode = userVerifycode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
