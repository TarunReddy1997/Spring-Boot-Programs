<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="ShowError.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">Mathematics</h3>
<%
	String str1=request.getParameter("t1");
	String str2 =request.getParameter("t2");
	double nr=Double.parseDouble(str1);
	double dr=Double.parseDouble(str2);
%>
<center>
	Numerator is:<%=nr %><br>
	Denominator is:<%=dr %><br>
	Quotient is:<%=nr/dr %>
</center>
</body>
</html>