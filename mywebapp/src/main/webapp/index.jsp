<%@page import="java.util.Date"%>
<%!
	public void jspInit() {
		System.out.println("init");

	}
	int c=9;
	public void jspDestroy() {
		System.out.println("Destroy");

	}
%>
<% int count=9; 
Date date=new Date(); 
int c=0;
%>
	
<html>
<body>
	<h2>Hello World!</h2>
	<h3>count value = <%=count %></h3>
	<h2>Current Date is </h2>
	<h3><%=date %></h3>
	
	<h3><%=c %></h3>
</body>
</html>
