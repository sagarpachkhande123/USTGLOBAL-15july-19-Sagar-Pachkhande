package com.dev.Attribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dto.EmployeeInfoBean;

@WebServlet("/myContextAttribute2")
public class MyAttributeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ServletContext context=getServletContext();
		EmployeeInfoBean bean=(EmployeeInfoBean) context.getAttribute("emp");
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h2>Employee Deatails are</h2>");
		pw.println("Name: "+bean.getName());
		pw.println("<br>Id: "+bean.getId());
		pw.println("<br>Age: "+bean.getAge());
		pw.println("<br>Designation: "+bean.getDesignation());
		pw.println("</body>");
		pw.println("</html>");
	}
}
