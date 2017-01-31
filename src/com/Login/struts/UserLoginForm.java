package com.Login.struts;

import org.apache.struts.action.ActionForm;

public class UserLoginForm extends ActionForm {

	String emailid,password;

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
