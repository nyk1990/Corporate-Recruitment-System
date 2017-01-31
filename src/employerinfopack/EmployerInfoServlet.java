package employerinfopack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jms.SendMail;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.omg.CORBA.Request;

public class EmployerInfoServlet extends HttpServlet {

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
try{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
	
		Random r=new Random();
		int i=r.nextInt(1000);
		String company_name=request.getParameter("company_name");
		String emailid=request.getParameter("company_emailid"),
		password=request.getParameter("company_pwd"),
		person=request.getParameter("Contact_person"),
		designation=request.getParameter("designation"),
		contactno=request.getParameter("contactno"),
		website=request.getParameter("weburl"),
		company_profile=request.getParameter("company_profile");
		String key=company_name+i;
		System.out.println(key);
		EmployerInfo e=new EmployerInfo(key, company_name, emailid, password, person, designation, contactno, website, company_profile);

		SendMail mail=new SendMail();
        mail.SendEMail(key,company_name,emailid,password);
		Transaction tr=ss.beginTransaction();
		ss.save(e);
		tr.commit();
		ss.close();
		
		RequestDispatcher rd1=request.getRequestDispatcher("");
}
catch(Exception e)
{
System.out.println(e);	
}
}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
