package generalinfopack;

/**
 * Generalinfo entity. @author MyEclipse Persistence Tools
 */

public class Generalinfo implements java.io.Serializable {

	// Fields

	private String userid;
	private String firstname;
	private String middlename;
	private String lastname;
	private String email;
	private String password;
	private String address;
	private String mobileno;
	private String city;
	private Integer pincode;
	private String nationality;
	private String gender;
	private String currentcity;
	private String dob;

	// Constructors

	/** default constructor */
	public Generalinfo() {
	}

	/** minimal constructor */
	public Generalinfo(String userid) {
		this.userid = userid;
	}

	/** full constructor */
	public Generalinfo(String userid, String firstname, String middlename,
			String lastname, String email, String password, String address,
			String mobileno, String city, Integer pincode, String nationality,
			String gender, String currentcity, String dob) {
		this.userid = userid;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobileno = mobileno;
		this.city = city;
		this.pincode = pincode;
		this.nationality = nationality;
		this.gender = gender;
		this.currentcity = currentcity;
		this.dob = dob;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileno() {
		return this.mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPincode() {
		return this.pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCurrentcity() {
		return this.currentcity;
	}

	public void setCurrentcity(String currentcity) {
		this.currentcity = currentcity;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}