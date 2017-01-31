package com.Login.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UserLoginController extends Action {

	Connection con;
	ResultSet rs;
	HttpSession session_login;
	@Override
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		UserLoginForm l=(UserLoginForm)form;
		String email=l.getEmailid();
		String pass=l.getPassword();
		
		System.out.println("emial"+email);
		
		
		
		PreparedStatement p=con.prepareStatement("select * from generalinfo where Email=?");
		p.setString(1,email);
		//p.setString(2,pass);
		rs=p.executeQuery();
		//rs.last();
		int i=rs.getRow();
		
		System.out.println("GetRow()="+rs.getRow());
		//System.out.println(i);
		while(rs.next())
		{
			if(rs.getString(5).equals(pass) && rs.getString(6).equals(email))
				
			{
				System.out.println("search "+session_login);
				session_login=request.getSession(false);
				session_login.setAttribute("userid",rs.getString("Userid"));
				String name=rs.getString("Firstname")+ " "+rs.getString("Lastname");
				session_login.setAttribute("name",name);
				return mapping.findForward("search");
						
			}
			else
			{
				break;
			}
			
		}
		//session_login.setAttribute("error","Emailid and password do not match");
		return mapping.findForward("Userlogin");
		
	
	}
	public UserLoginController() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recruitment_database","root","");
			System.out.println("success");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	

}
