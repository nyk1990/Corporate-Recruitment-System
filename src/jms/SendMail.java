package jms;
//import com.jscape.inet.smtp.Smtp;
import com.jscape.inet.smtpssl.*;
import com.jscape.inet.email.*;


public class SendMail 
{
	public void SendEMail(String key,String name,String emailid,String password)
	{
		
		SmtpSsl smtp = null;
    		/* gmail username */
		String username = "rapidjobs.2011@gmail.com";
    		/* gmail password */
		String pass = "rapidjobs2011";
    		/* address to send mail to */
		String to = emailid;
		try {
			/* Create a new SmtpSsl instance connecting securely via port 465 using implicit SSL */
			smtp = new SmtpSsl("smtp.gmail.com",465);
       
			/* Establish secure connection */
			smtp.connect();
       
			/* Login using gmail account details */
			smtp.login(username,pass);
       
			/* Create new email message */
			EmailMessage message = new EmailMessage();

			message.setTo(to);
			message.setFrom(username);
			message.setSubject("Company Registration");
			message.setBody("Dear Customer....This Is To Inform You That You Have Been Registered For rapidojobs.com. Your Company Id is: "+key+" and Password is : "+pass);
       
			/* Send message */
			smtp.send(message);
       
			/* Disconnect/Logout */      
			smtp.disconnect();
		}
		catch(Exception e) {}
	}
}
