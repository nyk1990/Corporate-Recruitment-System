package employerinfopack;



/**
 * EmployerInfo entity. @author MyEclipse Persistence Tools
 */

public class EmployerInfo  implements java.io.Serializable {


    // Fields    

     private String companyId;
     private String companyName;
     private String emailId;
     private String password;
     private String contactPerson;
     private String designation;
     private String contactNo;
     private String webUrl;
     private String companyProfile;


    // Constructors

    /** default constructor */
    public EmployerInfo() {
    }

	/** minimal constructor */
    public EmployerInfo(String companyId) {
        this.companyId = companyId;
    }
    
    /** full constructor */
    public EmployerInfo(String companyId, String companyName, String emailId, String password, String contactPerson, String designation, String contactNo, String webUrl, String companyProfile) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.emailId = emailId;
        this.password = password;
        this.contactPerson = contactPerson;
        this.designation = designation;
        this.contactNo = contactNo;
        this.webUrl = webUrl;
        this.companyProfile = companyProfile;
    }

   
    // Property accessors

    public String getCompanyId() {
        return this.companyId;
    }
    
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmailId() {
        return this.emailId;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactPerson() {
        return this.contactPerson;
    }
    
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContactNo() {
        return this.contactNo;
    }
    
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getWebUrl() {
        return this.webUrl;
    }
    
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getCompanyProfile() {
        return this.companyProfile;
    }
    
    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile;
    }
   








}