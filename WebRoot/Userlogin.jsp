<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr">

<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
	<meta name="keywords" content="" />
	<meta name="author" content="" />
	<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
	<title>Website Template: Quietude - Empty Page (demo)</title>
</head>
<script type="text/javascript">

function validateemail()
{
var emailid=document.userlogin.emailid.value;
    	if(emailid==null || emailid=="")
    	{
    		alert("Please Enter emailid");
    		document.userlogin.emailid.focus();
    		return false;
    	}

}


</script>

<body>

<div id="wrapper">
<div id="wrapper_inner">

	<div id="toplinks">
		<div id="toplinks_inner">
			
			<ul>
				<li><a href="#">Feedback</a> |</li>
				<li><a href="#">Sitemap</a> |</li>
				<li><a href="#">Legal</a></li>
			</ul>

			<div class="clearer">&nbsp;</div>

		</div>
	</div>

	<div class="clearer">&nbsp;</div>

	<div id="header_inner"><h1><a href="#">RapidoJobs.Com</a></h1> 
			<span>Home for your &quot;Dream Job&quot;....</span></div>

		<div id="navigation">
		<div id="navigation_inner">
			
			<ul>
				<li class="current_page_item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/CRSProject/Home.jsp">Home</a></li>
				
				<li><a href="/CRSProject/Search.jsp">Search Jobs</a></li>
				<li><a href="/CRSProject/Userlogin.jsp">Job Seeker</a><a href="/CRSProject/Employers.jsp">Employers<br /></a></li>
				<li><a href="/CRSProject/AboutUs.jsp">About Us<br /></a></li>
			</ul>

		</div>
	</div>



	<div id="main">

		<div class="left" id="content">
			<div id="content_inner"><br /><p><br /></p><p>.</p>
										
			</div>
		</div>	

		<div class="right" id="sidebar_outer">
			<div id="sidebar">
				
				<div class="box">

					<div class="box_title"><font size="2">Job Seeker Login Here</font><br /></div>
					<form name="userlogin" action="http://localhost:8080/CRSProject/Userlogin.do" method="post"><label> Email Id</label> <input type="text" name="emailid" onfocus="validateemail();"   class="mrgn_b10 mrgn_w5 inp_login" id="txtUseName" style="margin-top: 2px; width: 180px; color: rgb(153, 153, 153); height: 25px;" /><br />     
 
<label class="pad5 blck2">Password:</label><br />     
<input type="password" name="password" class="mrgn_b10 mrgn_w5 lbl inp_login" style="margin-top: 2px; width: 180px; height: 25px;" />     
<div class="blue-btn">     
<input border="0" type="submit" value="Sign In" style="width: 100px; height: 30px; font-weight: bold;" /></form><br /><br /><form action="Register.jsp"><input type="image" src="img/sign_up_home_page.png"  /></form><br />     
</div></div>
<br />
<div class="box"><br />

					<div class="box_content">
						<ul></ul>
					</div>

				</div>

				<div class="box"><br /></div>

				<div class="box">

					

					<div class="box_content">

						<div class="thumbnails">&nbsp; <a href="#" class="thumb"><br /></a>&nbsp;&nbsp;&nbsp;&nbsp;

							<div class="clearer">&nbsp;</div>

						</div>

					</div>

				</div>

			</div>
		</div>

		<div class="clearer">&nbsp;</div>

		<div id="footer">
			<div id="footer_inner">
				
				<div class="left">
					&copy; 2008 Website.com - Your Site Slogan
				</div>

				<div class="right">
					<a href="http://templates.arcsin.se/">Website template</a> by <a href="http://arcsin.se/">Arcsin</a> 
				</div>
				
				<div class="clearer">&nbsp;</div>

			</div>
		</div>

	</div>

</div>
</div>

</body>
</html>