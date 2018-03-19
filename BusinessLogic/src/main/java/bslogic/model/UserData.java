package bslogic.model;

import java.util.Date;

public class UserData {

	private int userDataId;
	private String nickname;
	private String userName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
	private String userPwd;
	private int userAge;
	private Date registerDate;
	private UserAddress userAddress;
	
	public UserData(){
		
	}

	public int getUserDataId() {
		return userDataId;
	}

	public void setUserDataId(int userId) {
		this.userDataId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "UserDataId: " + this.userDataId + ", user_nickName: " + this.nickname + ", user_Name: " + this.userName
				+ ", user_lastName: " + this.lastName + ", email: " + this.emailAddress + ", phone: " + this.phoneNumber
				+ ", user_age: " + this.userAge + ", registration_date: " + this.registerDate;
	}

}
