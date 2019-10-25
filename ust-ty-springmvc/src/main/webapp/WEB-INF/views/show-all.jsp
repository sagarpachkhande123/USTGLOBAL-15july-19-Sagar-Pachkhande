<%@page import="com.tyss.usttyspringmvc.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	List<Employee> employees=(List)request.getAttribute("list");
    	Employee emp=(Employee)session.getAttribute("emp");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employee</title>
<style >

body {
  background-color: linen;
}

h1 {
  color: maroon;
  margin-left: 40px;
}
</style>
</head>
<body>

<div align="right">
	<span><a href="./update">Update Profile</a></span>	
	<span><a href="./delete?id=<%=emp.getId()%>">Delete Profile</a></span>
	<span><a href="./logout">Logout</a></span>	
	</div>
	
<center>	
<h1>Employee Data</h1>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>DOB</th>
			<th>Email</th>
		</tr>
		
		<%
			for(Employee employee:employees)
			{
		%>
		<tr>
			<td><%=employee.getId() %></td>
			<td><%=employee.getName() %></td>
			<td><%=employee.getDob() %></td>
			<td><%=employee.getEmail() %></td>
		</tr>
		<%
			}
		%>
	
	</table>
	
	</center>
</body>
</html>