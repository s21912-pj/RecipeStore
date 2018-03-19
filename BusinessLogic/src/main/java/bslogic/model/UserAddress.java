package bslogic.model;

public class UserAddress {

	private int userId;
	private String street;
	private String city;
	private int houseNumber;
	private String postalCode;
	private int appartmentNumber;
	private String province;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getAppartmentNumber() {
		return appartmentNumber;
	}

	public void setAppartmentNumber(int appartmentNumber) {
		this.appartmentNumber = appartmentNumber;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "userId: " + this.userId + ",street: " + this.street + ", city: " + this.city + ", houseNum: "
				+ this.houseNumber + ", postalCode: " + this.postalCode + ", appartment_number: "
				+ this.appartmentNumber + ", province: " + this.province;
	}

}
