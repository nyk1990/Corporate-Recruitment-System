package qualifications_pack;

/**
 * EducationalQualification entity. @author MyEclipse Persistence Tools
 */

public class EducationalQualification implements java.io.Serializable {

	// Fields

	private String userid;
	private String highestQualification;
	private String specialization;
	private String institute;
	private Double aggregate;
	private Integer yop;
	private String highestQualification2;
	private String specialization2;
	private String institute2;
	private Double aggregate2;
	private Integer yop2;

	// Constructors

	/** default constructor */
	public EducationalQualification() {
	}

	/** minimal constructor */
	public EducationalQualification(String userid) {
		this.userid = userid;
	}

	/** full constructor */
	public EducationalQualification(String userid, String highestQualification,
			String specialization, String institute, Double aggregate,
			Integer yop, String highestQualification2, String specialization2,
			String institute2, Double aggregate2, Integer yop2) {
		this.userid = userid;
		this.highestQualification = highestQualification;
		this.specialization = specialization;
		this.institute = institute;
		this.aggregate = aggregate;
		this.yop = yop;
		this.highestQualification2 = highestQualification2;
		this.specialization2 = specialization2;
		this.institute2 = institute2;
		this.aggregate2 = aggregate2;
		this.yop2 = yop2;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getHighestQualification() {
		return this.highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public String getSpecialization() {
		return this.specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getInstitute() {
		return this.institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public Double getAggregate() {
		return this.aggregate;
	}

	public void setAggregate(Double aggregate) {
		this.aggregate = aggregate;
	}

	public Integer getYop() {
		return this.yop;
	}

	public void setYop(Integer yop) {
		this.yop = yop;
	}

	public String getHighestQualification2() {
		return this.highestQualification2;
	}

	public void setHighestQualification2(String highestQualification2) {
		this.highestQualification2 = highestQualification2;
	}

	public String getSpecialization2() {
		return this.specialization2;
	}

	public void setSpecialization2(String specialization2) {
		this.specialization2 = specialization2;
	}

	public String getInstitute2() {
		return this.institute2;
	}

	public void setInstitute2(String institute2) {
		this.institute2 = institute2;
	}

	public Double getAggregate2() {
		return this.aggregate2;
	}

	public void setAggregate2(Double aggregate2) {
		this.aggregate2 = aggregate2;
	}

	public Integer getYop2() {
		return this.yop2;
	}

	public void setYop2(Integer yop2) {
		this.yop2 = yop2;
	}

}