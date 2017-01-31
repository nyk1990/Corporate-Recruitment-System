<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>  
<%  
  if((request.getParameter("BounceServerA") != null)) {  
    session.setAttribute("submitted", "yes");  
    System.out.println("I should not be called on refresh!!");  
                                                                                                                 
    // Use a redirect to dump the post data.  
    response.sendRedirect("BounceServer.jsp");  
    return;  
  }  
%>  
<html>  
  <head>  
    <title>Application Server Bounce</title></head>  
  <body>  
    <%  
      if("yes".equals((String)session.getAttribute("submitted"))){  
        System.out.println("==========it is now working");  
      }  
    %>  
    <form name="form1" method="post" action="Temp.jsp">  
      <p>Select the server application to bounce. </p>  
      <input type="Submit" name="BounceServerA" value="Bounce Application on Server1" >  
    </form1>  
  </body>  
</html>  
   