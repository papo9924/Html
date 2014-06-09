<%@ page language="java" 
contentType="text/html"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.Date" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Soy Genial</title>
</head>
<body>
<%@ include file="Copyright.jsp" %>
<%--Esto es un comentario desde JSP --%>
<!--Esto es un comentario desde HTML -->
<%="Hola Mundo"+ new Date().toString() %>
<% String test=request.getParameter("test");
out.println("Hola Mundo"+ new Date().toString());%>
<%
String[] values = new String[3];
values[0]= "ERES";
values[1]= "MUY";
values[2]= "......";
for(String value :values){
out.println("<div>"+ value + "</div>");
}
%>
<%@ include file="Copyright.jsp" %>
</body>
</html>