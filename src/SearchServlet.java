import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
public class SearchServlet extends HttpServlet {

	HttpSession session1;
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html PUBLIC -//W3C//DTD XHTML 1.0 Transitional//EN http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd>");
		out.print("<html xmlns=http://www.w3.org/1999/xhtml dir=ltr>	<head><meta http-equiv=content-type content=text/html; charset=UTF-8/>	<meta name=description /><meta name=keywords  />	<meta name=author  />");
		out.print("<link rel=stylesheet type=text/css href=style.css media=screen /><title>Website Template: Quietude - Arhives (demo)</title>	</head>	<body>	<div id=wrapper><div id=wrapper_inner><div id=toplinks>	<div id=toplinks_inner>");
		out.print("<ul>	</ul><div class=clearer>&nbsp;</div></div></div><div class=clearer>&nbsp;</div><div id=header><div id=header_inner><h1><a href=#>RapidoJobs.Com</a></h1><span>Home for your &quot;Dream Job&quot;....</span></div>");
			out.print("</div><div id=navigation><div id=navigation_inner><ul><li class=current_page_item>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href=/CRSProject/Home.jsp>Home</a></li><li><a href=/CRSProject/Search.jsp>Search Jobs</a></li><li><a href=/CRSProject/Userlogin.jsp>Job Seeker</a><a href=/CRSProject/Employers.jsp>Employers<br /></a></li>");
			out.print("<li><a href=/CRSProject/AboutUs.jsp>About Us<br /></a></li>");
	session1=request.getSession();
	
//	String user=session1.getAttribute("name").toString();
	//if(!user.equals(null))
	{	out.print("<li><a href=/CRSProject/Logout.jsp>Logout<br /></a></li>");
	}
	out.print("</ul></div></div>");
		out.print("<div id=main><div class= left  id= content >	<div id= content_inner ><h2><br /></h2><br /><br /><form method= get  name= Searchform  action= http://localhost:8080/CRSProject/SearchServlet >Location&nbsp;&nbsp;");
out.print("<select name= location ><option value= Agra >Agra</option>");  
out.print("<option value= Ahemedabad >Ahemedabad</option><option value= Bangluru >Bangluru</option>  <option value= Baroda >Baroda</option>  <option value= Bhopal >Bhopal</option>  <option value= Chennai >Chennai</option><option value= Delhi >Delhi</option>  <option value= Panjim >Panjim</option>  <option value= Gurgaon >Gurgaon</option>  <option value= Hyderabad >Hyderabad</option>  <option value= Lucknow >Lucknow</option>  <option value= Mumbai >Mumbai</option>  <option value= Mysore >Mysore</option>  <option value= Nagpur >Nagpur</option>  <option value= New Delhi >New Delhi</option>  <option value= Noida >Noida</option>  <option value= Pune >Pune</option>  </select> </p>");
		out.print("<p>Job Category 	<select name= job_category ><optgroup label= Top Categories ></optgroup><option value= Accounts, Finance, Tax, Company Secretary, Audit  >Accounts, Finance, Tax, Company Secretary, Audit</option><option value= Financial Services, Banking, Investments, Insurance  >Financial Services, Banking, Investments, Insurance</option><option value= ITES, BPO, KPO, LPO, Customer Service, Operations  >ITES, BPO, KPO, LPO, Customer Service, Operations</option><option value= HR, Recruitment, Administration, IR  >HR, Recruitment, Administration, IR</option><option value= Marketing, Advertising, MR, PR, Media Planning  >Marketing, Advertising, MR, PR, Media Planning</option><option value= Production, Manufacturing, Maintenance  >Production, Manufacturing, Maintenance</option>	<option value= Site Engineering, Project Management  >Site Engineering, Project Management</option><option value= Engineering Design, R&D  >Engineering Design, R&D</option><option value= Sales, Retail, Business Development  >Sales, Retail, Business Development </option><option value= IT Software - All Jobs  >IT Software - All Jobs</option><optgroup label= IT Software Categories ></optgroup><option value= Application Programming, Maintenance  >Application Programming, Maintenance</option><option value= Client / Server Programming  >Client / Server Programming</option><option value= DBA, Datawarehousing  >DBA, Datawarehousing</option><option value= ERP, CRM  >ERP, CRM</option><option value= Embedded, EDA, VLSI, ASIC, Chip Design  >Embedded, EDA, VLSI, ASIC, Chip Design</option><option value= Network Administration, Security  >Network Administration, Security</option><option value= QA & Testing  >QA & Testing</option><option value= System Programming  >System Programming</option><option value= Telecom Software  >Telecom Software</option><option value= Systems, EDP, MIS  >Systems, EDP, MIS</option><option value= eCommerce, Internet Technologies  >eCommerce, Internet Technologies</option><option value= Mainframe  >Mainframe</option><option value= Mobile  >Mobile</option><option value= Middleware  >Middleware</option><option value= Other  >Other</option>");
			out.print("</select><br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; <input type= submit  value= Submit  name= Submit  /> &nbsp; </p></form><br /><p>&nbsp;<br />");

			Connection con=null;
			ResultSet rs=null;
			Statement stmt=null;
			
			try {
					Class.forName( "com.mysql.jdbc.Driver");
					
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recruitment_database","root","");
					//out.println("success "+con);
					 
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String loc=request.getParameter("location"),
				job_cat=request.getParameter("job_category");
	
				//if location and job category are selected this block gets executed
				if(!loc.equals("null") && !job_cat.equals("null"))
				{
					PreparedStatement p;
				
				try {
					p = con.prepareStatement("select * from company_updates where  location=? and job_role=? order by srno desc");
					p.setString(1, loc);
					p.setString(2, job_cat);
				
					rs=p.executeQuery();
				 } catch (SQLException e) 
				 {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					out.println("<br/><br/><br/><br/><br/>");
					if(rs.last())
					{
					while(rs.next())
					{
						
					out.print("Company Name: "+rs.getString(2));
					out.print("<br/>Company Website: <a href="+rs.getString(3)+"/>"+rs.getString(3)+"</a>");
					out.print("<br/>Eligibility: "+rs.getString(4));
					out.print("<br/>Opening Locations: "+rs.getString(5));
					out.print("<br/>Job Role: "+rs.getString(6));
					out.print("<br/>Job Summary: "+rs.getString(7));
					out.println("<br/><br/><br/>");
					out.println();
					}
					}
					else
					{
						out.print("No matching jobs found");
						
					}
				}
				
		
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}//if ends with both fields
				
				//if only location is selecetd then this block gets executed
				
				else if(!loc.equals("null") && job_cat.equals("null"))
				{
					PreparedStatement p;
				
				try {
					p = con.prepareStatement("select * from company_updates where  location=?  order by srno desc");
					p.setString(1, loc);
				
					rs=p.executeQuery();
				 } catch (SQLException e) 
				 {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					out.println("<br/><br/><br/><br/><br/>");
					if(rs.last())
					{
					while(rs.next())
					{
						
					out.print("Company Name: "+rs.getString(2));
					out.print("<br/>Company Website: <a href="+rs.getString(3)+"/>"+rs.getString(3)+"</a>");
					out.print("<br/>Eligibility: "+rs.getString(4));
					out.print("<br/>Opening Locations: "+rs.getString(5));
					out.print("<br/>Job Role: "+rs.getString(6));
					out.print("<br/>Job Summary: "+rs.getString(7));
					out.println("<br/><br/><br/>");
					out.println();
					}
					}
				}
				
		
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}//else with location ends
				
				//if job role is selected this block gets executed
				else if(loc.equals("null") && !job_cat.equals("null"))
				{
					PreparedStatement p;
				
				try {
					p = con.prepareStatement("select * from company_updates where   job_role=? order by srno desc");
					
					p.setString(2, job_cat);
				
					rs=p.executeQuery();
				 } catch (SQLException e) 
				 {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					out.println("<br/><br/><br/><br/><br/>");
					if(rs.last())
					{
					while(rs.next())
					{
						
					out.print("Company Name: "+rs.getString(2));
					out.print("<br/>Company Website: <a href="+rs.getString(3)+"/>"+rs.getString(3)+"</a>");
					out.print("<br/>Eligibility: "+rs.getString(4));
					out.print("<br/>Opening Locations: "+rs.getString(5));
					out.print("<br/>Job Role: "+rs.getString(6));
					out.print("<br/>Job Summary: "+rs.getString(7));
					out.println("<br/><br/><br/>");
					out.println();
					}
					}
				}
				
		
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}//else with job field ends
				
				//if none is selected then this gets executed
				else 
				{
						PreparedStatement p;
					
					try {
						p = con.prepareStatement("select * from company_updates order by srno desc");
					
						rs=p.executeQuery();
					 } catch (SQLException e) 
					 {
						// TODO Auto-generated catch block
						e.printStackTrace();
							}
							try {
								out.println("<br/><br/><br/><br/><br/>");
								if(rs.last())
								{
									System.out.println("none is selected");
									//for(int i=0;i<10;i++)
									{
										//if(i<10)
										{
												while(rs.next())
											  {
											
												out.print("Company Name: "+rs.getString(2));
												out.print("<br/>Company Website: <a href="+rs.getString(3)+"/>"+rs.getString(3)+"</a>");
												out.print("<br/>Eligibility: "+rs.getString(4));
												out.print("<br/>Opening Locations: "+rs.getString(5));
												out.print("<br/>Job Role: "+rs.getString(6));
												out.print("<br/>Job Summary: "+rs.getString(7));
												out.println("<br/><br/><br/>");
												out.println();
											  }
								  
										}
										
										//else
										//	break;
						}	
					}
				}
				
		
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
	
	
	
	
	out.close();
	
	}
	
			
			
			
			
			/** @throws ServletException if an error occurs */	
			public void init() throws ServletException {
		// Put your code here
	}

}
