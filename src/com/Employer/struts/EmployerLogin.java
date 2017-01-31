package com.Employer.struts;

import org.apache.struts.action.ActionForm;

public class EmployerLogin extends ActionForm
{
	String emailid;
	String password;
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
