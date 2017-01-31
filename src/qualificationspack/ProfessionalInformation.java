package qualificationspack;

/**
 * ProfessionalInformation entity. @author MyEclipse Persistence Tools
 */

public class ProfessionalInformation implements java.io.Serializable {

	// Fields

	private String userid;
	private String functionalArea;
	private String currentRole;
	private String areaOfSpecialization;

	// Constructors

	/** default constructor */
	public ProfessionalInformation() {
	}

	/** minimal constructor */
	public ProfessionalInformation(String userid) {
		this.userid = userid;
	}

	/** full constructor */
	public ProfessionalInformation(String userid, String functionalArea,
			String currentRole, String areaOfSpecialization) {
		this.userid = userid;
		this.functionalArea = functionalArea;
		this.currentRole = currentRole;
		this.areaOfSpecialization = areaOfSpecialization;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFunctionalArea() {
		return this.functionalArea;
	}

	public void setFunctionalArea(String functionalArea) {
		this.functionalArea = functionalArea;
	}

	public String getCurrentRole() {
		return this.currentRole;
	}

	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}

	public String getAreaOfSpecialization() {
		return this.areaOfSpecialization;
	}

	public void setAreaOfSpecialization(String areaOfSpecialization) {
		this.areaOfSpecialization = areaOfSpecialization;
	}

}