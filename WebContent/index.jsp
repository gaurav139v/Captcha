<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Captcha</title>
<style>
	body{
		margin:auto;
		widht:960px;
		background-color:lightblue;
	}
	.box{
		width:300px;
		height:400xp;
		margin-top:80px;
		margin-left:580px;
		position:absolute;
	}
	
	#inputField{
		width:180px;
		height:25px;
		margin-top:20px;
		font-size:20px;
	}
	
	#ref{
		float:left;
		margin-left:80px;
	}
	
	#btn{
		width:70px;
		height:25px;
		color:green;
		margin-right:30px;
	}
</style>

</head>
<body>
<%@page import="com.captcha.Captcha"%>
<%@page import="com.captcha.NumberType"%>
<%@page import="com.captcha.AlphaNumericType"%>
<%  
	// Create a captcha objec
	Captcha n = new AlphaNumericType();
	n.createCaptcha();
	System.out.println(n.getCapt().toString());
	System.out.println(n.getImageData().toString());
	String s = n.getImageData();
%>

<%	String str = null;
	Object o = request.getAttribute("msg");
	str = (String)o;	
%>


<center><h1>Captcha</h1></center>
<form action="captchaCheck" method="post">
<center>	
	<div class="box">
		<input type="text"  name="val" value="<%=n.getCapt() %>" hidden >
		<img src="data:image/jpg;base64, <%=s%>" alt="Captcha" id ="img" /><br>
		<input type="text" id="inputField" name="input" required ><br><br>
		<img src="img/refresh.png" width="30px" height="30px" id="ref" onClick="window.location.reload()" />
		<button id="btn" >Submit</button>
	</div>
</center>
</form>


<center >
	<h2>
		<%
			if(str != null){
				%><%=str%><%
			}
			str = null;			
		%>
	</h2>
</center>

</body>
</html>