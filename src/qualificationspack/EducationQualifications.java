package qualificationspack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class EducationQualifications extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	HttpSession session1;
	

	public EducationQualifications() {
		super();
	}

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
		
		session1=request.getSession(true);
		String key=session1.getAttribute("userid").toString();
		
		
		//System.out.println("Educationervlet "+key);
		//System.out.println("EducationalQualificationservlet "+key);
		
		EducationalQualification e=new EducationalQualification(key,request.getParameter("highest_qualification"),request.getParameter("specialization"),request.getParameter("institute"),Double.parseDouble(request.getParameter("aggregate").trim()),Integer.parseInt(request.getParameter("yop").trim()),request.getParameter("highest_qualification_2"),request.getParameter("specialization_2"),request.getParameter("institute_2"),Double.parseDouble(request.getParameter("aggregate_2").trim()),Integer.parseInt(request.getParameter("yop_2").trim()));
		ProfessionalInformation p=new ProfessionalInformation(key,request.getParameter("functional_area"),request.getParameter("current_role_"),request.getParameter("area_of_specialization"));
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		org.hibernate.Session s=sf.openSession();
		
		Transaction tr=s.beginTransaction();
		s.save(e);
		tr.commit();
		
		System.out.println("fa "+request.getParameter("functional_area"));
		System.out.println("cr "+ request.getParameter("current_role_"));
		System.out.println("aos "+request.getParameter("area_of_specialization"));		
		
		s.close();
		
		Session s1=sf.openSession();
		s1.save(p);
		Transaction tr1=s1.beginTransaction();
		tr1.commit();
		
		s1.close();
		
		RequestDispatcher rd=request.getRequestDispatcher("/Search.jsp");
		rd.forward(request, response);
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
