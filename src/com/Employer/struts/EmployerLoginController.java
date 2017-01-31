package com.Employer.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EmployerLoginController extends Action 
{
	Connection con=null;
	ResultSet rs=null;
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		// TODO Auto-generated method stub
		EmployerLogin e=(EmployerLogin)form;
		String emailid=e.getEmailid();
		String password=e.getPassword();
		
		PreparedStatement pstmt=con.prepareStatement("select * from employer_info where Email_id=?");
		pstmt.setString(1,emailid);
		
		rs=pstmt.executeQuery();
		//rs.last();
		int i=rs.getRow();
		
		System.out.println("GetRow()="+rs.getRow());
		
		while(rs.next())
		{
			if(rs.getString(4).equals(password) && rs.getString(3).equals(emailid))
			{
				return mapping.findForward("empupdates");
			}
			else
			{
				break;
			}
		}
		return mapping.findForward("employers");
		
		
	}
	
	public EmployerLoginController() {
		// TODO Auto-generated constructor stub
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
