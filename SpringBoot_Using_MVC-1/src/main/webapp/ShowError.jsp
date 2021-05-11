<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page isErrorPage="true" %>
<h4>This is ShowErrors.jsp page.Showing the error of Errors.jsp</h4>
The following errors occured<hr>
<%exception.printStackTrace(new PrintWriter(out)); %>
</body>
</html>