<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <FORM ENCTYPE="multipart/form-data" ACTION="http://localhost:8080/CRSProject/upload_page.jsp" METHOD=POST>
<br><br><br>
<center>
<table border="0" bgcolor=#ccFDDEE>
<tr>
<center>
<td colspan="2" align="center"><B>UPLOAD THE FILE</B><center></td>
</tr>
<tr>
<td colspan="2" align="center">&nbsp;</td>
</tr>
<tr>
<td><b>Choose the file To Upload:</b></td>
<td><INPUT NAME="file" TYPE="file"></td>
</tr>
<tr>
<td colspan="2" align="center">&nbsp;</td>
</tr>
<tr>
<td colspan="2" align="center"><INPUT TYPE="submit" VALUE="Send File" ></td>
</tr>
<table>
</center> 
</FORM>
  </body>
</html>
