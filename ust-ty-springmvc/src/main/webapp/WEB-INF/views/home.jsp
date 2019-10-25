<%@page import="com.tyss.usttyspringmvc.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	Employee employee=(Employee)session.getAttribute("emp");
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>

<style>

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
	<span><a href="./delete?id=<%=employee.getId()%>">Delete Profile</a></span>
	<span><a href="./logout">Logout</a></span>	
	</div>


<h1>Welcome <%=employee.getName()%></h1>
<h3><a href="./show-all">Show All Employee</a></h3>


</body>
</html>