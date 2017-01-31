package generalinfopack;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

public class GeneralInfoServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	HttpSession session;
	java.sql.Connection con=null;
	java.sql.ResultSet  rs;
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

		
		
		session =request.getSession(true);
		
		response.setContentType("text/html");
	System.out.println("in generalinfo");
		String fname=request.getParameter("fname"),
		mname=request.getParameter("mname"),lname=request.getParameter("lname"),
		emailid=request.getParameter("emailid"),pwd=request.getParameter("pwd"),
		addr=request.getParameter("addr"),city=request.getParameter("city"),
		nationality=request.getParameter("nationality"),gender=request.getParameter("gender"),
		currcity=request.getParameter("currcity"),dd=request.getParameter("dd"),mm=request.getParameter("mm"),
		yy=request.getParameter("yy");
		String mobno=request.getParameter("mobno");
		System.out.println(request.getParameter("fname")+" fname pincode");
		int  pin=Integer.parseInt(request.getParameter("pincode"));
		String dob=dd+"/"+mm+"/"+yy;
		
		//userid generatrion takes place
		
		Random r=new Random();
		int i=r.nextInt(10000);
		String key=fname+i;
		session.setAttribute("userid", key);//userid is available througout session
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		//To check wether emailid is  already present in databse
		session.setAttribute("user", fname);
		
		/*Session ss=sf.openSession();
		Query q=ss.createQuery("from Generalinfo where Email=:emailid");
		q.setParameter("emailid", emailid);*/
		//System.out.println(currcity+" "+request.getParameter("currcity"));
		String str="select * from generalinfo where Email=?";
		try {
			PreparedStatement ps=con.prepareStatement(str);
			System.out.println(con);
			ps.setString(1,emailid);
			rs=ps.executeQuery();
			
			System.out.println("Rows Returned "+rs.getRow());
		System.out.println(rs.last());
			while(rs.next())
			{
				if(rs.getString("Email").equals(emailid))
				{
					session.setAttribute("error","Email Id already exists");
					System.out.println("error");
					
					//String error="Email Id already present";
					RequestDispatcher rd=request.getRequestDispatcher("/Register.jsp");
					rd.include(request, response);
					
				}
			}	
				
				{
					Generalinfo g=new Generalinfo(key,fname, mname, lname, emailid, pwd, addr, mobno, city, pin, nationality, gender, currcity, dob);
					System.out.println(g);
					Transaction tr=s.beginTransaction();
					s.save(g);
					tr.commit();
					//System.out.println("transaction commit");
					
					s.close();
					
					RequestDispatcher rd=request.getRequestDispatcher("/ProfessionalQualifications.jsp");
					rd.include(request, response);
					
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		
		
	
		}
	
	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recruitment_database","root","");
			System.out.println("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
