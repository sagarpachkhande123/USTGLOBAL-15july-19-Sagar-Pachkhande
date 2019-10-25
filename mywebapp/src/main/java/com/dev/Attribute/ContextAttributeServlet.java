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

@WebServlet("/contextAttributeServlet")
public class ContextAttributeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeInfoBean bean=new EmployeeInfoBean();
		bean.setId(1098);
		bean.setAge(22);
		bean.setName("PPPP");
		bean.setDesignation("Developer");
		bean.setSalary(989);
		
		ServletContext context=getServletContext();
		context.setAttribute("emp", bean);
		
		resp.setContentType("text/html");
		PrintWriter printWriter=resp.getWriter();
		printWriter.println("<html>");
		printWriter.println("<body>");
		printWriter.println("<h3>Context Attribute has been set..</h3>");
		printWriter.println("</body>");
		printWriter.println("</html>");
	}//End of doGet()
}//End Of Class
