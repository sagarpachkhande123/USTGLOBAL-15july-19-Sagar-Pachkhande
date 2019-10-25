package com.dev.Servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getemp")
public class GetEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String empid=req.getParameter("Empid");
		String name=req.getParameter("uname");
		String password=req.getParameter("password");
		
		PrintWriter pw=resp.getWriter();
		
		resp.setContentType("text/html");
		pw.println("<html>");
		pw.println("<body>");
		if(empid.equals("101"))
		{
			pw.println("<h2>User is Found with Employee id "+empid+" </h2>");
			pw.println("<h3>Name:: "+name+"</h3>" );
			pw.println("<h3>Password:: "+password+"</h3>" );
		}
		else {
			pw.println("<h2 style=color:\"red\">User is not found</h2>");
		}
		pw.println("</body>");
		pw.println("</html>");
	}
}
