package qualifications_pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class AcademicsInfoServlet extends HttpServlet {

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

	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session s=sf.openSession();

	Transaction tr=s.beginTransaction();
	Random r=new Random();
	int a=r.nextInt(1000);
	String key="a"+a;

	EducationalQualification e=new EducationalQualification(key, request.getParameter("highest_qualification"), request.getParameter("specialization"), request.getParameter("institute"), Double.parseDouble(request.getParameter("aggregate").trim()),Integer.parseInt(request.getParameter("yop")),request.getParameter("highest_qualification_2"), request.getParameter("specialization_2"),request.getParameter("institute_2"),Double.parseDouble(request.getParameter("aggregate_2").trim()),Integer.parseInt(request.getParameter("yop_2").trim()));
	ProfessionalInformation p=new ProfessionalInformation(key,request.getParameter("functional_area"), request.getParameter("current_role"), request.getParameter("area_of_specialization"));
	
	
	
	
	RequestDispatcher rd=request.getRequestDispatcher("/Academics.jsp");
	rd.include(request, response);
	

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
