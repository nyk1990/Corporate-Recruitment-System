package companyinfopack;

/**
 * CompanyUpdates entity. @author MyEclipse Persistence Tools
 */

public class CompanyUpdates implements java.io.Serializable {

	// Fields

	private Integer srno;
	private String company;
	private String website;
	private String eligibility;
	private String location;
	private String jobRole;
	private String jobSummary;

	// Constructors

	/** default constructor */
	public CompanyUpdates() {
	}

	/** full constructor */
	public CompanyUpdates(String company, String website, String eligibility,
			String location, String jobRole, String jobSummary) {
		this.company = company;
		this.website = website;
		this.eligibility = eligibility;
		this.location = location;
		this.jobRole = jobRole;
		this.jobSummary = jobSummary;
	}

	// Property accessors

	public Integer getSrno() {
		return this.srno;
	}

	public void setSrno(Integer srno) {
		this.srno = srno;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEligibility() {
		return this.eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJobRole() {
		return this.jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getJobSummary() {
		return this.jobSummary;
	}

	public void setJobSummary(String jobSummary) {
		this.jobSummary = jobSummary;
	}

}