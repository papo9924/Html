<%@ page language="java" contentType="text/html;"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Task</title>
</head>
<body>
<script>
function Validar()
{
var title = document.forms["task_form"]["title"].value;
var description = document.forms["task_form"]["description"].value;
var category = document.forms["task_form"]["category"].value;
var priority = document.forms["task_form"]["priority"].value;
var owner = document.forms["task_form"]["owner"].value;


if(!title)
{
alert("TITULO VACIO");
return false;
} else if(!description)
{
alert("DESCRIPCION VACIA");
return false;
} else if(!category)
{
alert("CATEGORIA VACIA");
return false;
} else if(!priority)
{
alert("PRIORIDAD VACIA");
return false;
} else if(!owner)
{
alert("PROPIETARIO VACIO");
return false;
}
return true;
}
</script>

<form name = "task_form" method="POST" action = "NewTask" onsubmit="return Validate()">
<table>
<tr>
<td>Title:</td>
<td><input type="text" name="title" /></td>
</tr>
<tr>
<td>Description:</td>
<td><input type="text" name="description" /></td>
</tr>
<tr>
<td>State:</td>
<td>
<select name="state">
<option value="BACKLOG" selected>Backlog</option>
<option value="TO_DO">To do</option>
<option value="IN_PROGRESS">In progress</option>
<option value="DONE">Done</option>
</select>
</td>
</tr>
<tr>
<td>Category:</td>
<td><input type="text" name="category" /></td>
</tr>
<tr>
<td>Priority:</td>
<td><input type="text" name="priority" /></td>
</tr>
<tr>
<td>Owner:</td>
<td><input type="text" name="owner" /></td>
</tr>
<tr>
<td>Due date:</td>
<td><input type="text" name="due_date" value="00 00 2014" /></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Add" /></td>
</tr>
</table>
</form>


<br>
<br>


<%-- Esto es un comentario JSP --%>
<!-- Esto es un comentario en HTML -->
<% out.println("hola mundo" + new Date().toString()); %>

<%
String[] values = new String[3];
values[0] = "test";
values[1] = "test1";
values[2] = "test2";
for(String value : values){
out.println("<div>" + value + "</div>");
}
%>
<br>
<%@ include file= "Copyright.jsp" %>
</body>
</html>