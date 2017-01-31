<%@ page import="java.io.*,java.sql.*,java.util.*,java.text.*,java.text.SimpleDateFormat" %>
<html>
<%
int val =0;
	String contentType = request.getContentType();
	if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
 	DataInputStream in = new DataInputStream(request.getInputStream());
	int formDataLength = request.getContentLength();
	byte dataBytes[] = new byte[formDataLength];
	int byteRead = 0;
	int totalBytesRead = 0;
		
	while (totalBytesRead < formDataLength) {
	byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
	totalBytesRead += byteRead;
	}
	String file = new String(dataBytes);
	String saveFile = file.substring(file.indexOf("filename=\"") + 10);
	//System.out.println("saveFile=" + saveFile);
	saveFile = saveFile.substring(saveFile.lastIndexOf("\\")+ 1,saveFile.indexOf("\""));
	//System.out.println("saveFile" + saveFile);
	saveFile = file.substring(file.indexOf("filename=\"") + 10);
		saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
		saveFile = saveFile.substring(saveFile.lastIndexOf("\\")+ 1,saveFile.indexOf("\""));
		int lastIndex = contentType.lastIndexOf("=");
		String boundary = contentType.substring(lastIndex + 1,contentType.length());
		int pos;
		
		pos = file.indexOf("filename=\"");
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		int boundaryLocation = file.indexOf(boundary, pos) - 4;
		int startPos = ((file.substring(0, pos)).getBytes()).length;
		int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

		FileOutputStream fileOut = new FileOutputStream(saveFile);
		fileOut.write(dataBytes, startPos, (endPos - startPos));
		%>
		
		<%
			Connection con=null;
	    PreparedStatement pstatement = null;
        String line = null;
	    String value=null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "file_upload";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root"; 
			String password = "mysql";
        try{
			StringBuilder contents = new StringBuilder();
			BufferedReader input =  new BufferedReader(new FileReader(saveFile));
			while (( line = input.readLine()) != null){
			contents.append(line);
			}
			value = contents.toString();
			System.out.println("Value:"+value);
            Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url+dbName,userName,password);
            java.util.Date now = new java.util.Date();
		  String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
		   SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
 
  
    		String strDateNew = sdf.format(now) ;
		  
			
			
            
			String queryString ="INSERT INTO file_tbl set file_data='"+value+"',file_date='"+strDateNew+"'";
			
			//out.println(queryString);
			
			pstatement=con.prepareStatement(queryString);
			 
			
            val = pstatement.executeUpdate();
		
			if(val>0)
			{
				%>
				<br><br>
				 <b>File 	<% out.println(saveFile); %> has been uploaded and inserted into Database at <%=strDateNew%>.</b>
				<%
			}
			
			
           }
	catch(Exception e)
		{}
		}
	%>
</html>