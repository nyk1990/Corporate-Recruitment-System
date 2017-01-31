package companyinfopack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CompanyUpdatesServlet extends HttpServlet {

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

		try
		{
		String C_company=request.getParameter("C_company"),
		C_website=request.getParameter("C_website"),
		C_eligibility=request.getParameter("C_eligibility"),
		C_location=request.getParameter("C_location"),
		C_jobRole=request.getParameter("C_job_role"),
		C_jobSummary=request.getParameter("C_job_summary");
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		
		System.out.println("company "+C_company);
		CompanyUpdates c=new CompanyUpdates(C_company,C_website,C_eligibility,C_location,C_jobRole,C_jobSummary);
		
		
		Transaction tr=ss.beginTransaction();
		ss.save(c);
		tr.commit();
		ss.close();
		
		//RequestDispatcher rd=request.getRequestDispatcher("/EmployersUpdates.jsp");
		//rd.include(request, response);
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
