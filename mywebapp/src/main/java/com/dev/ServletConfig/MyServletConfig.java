package com.dev.ServletConfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServletConfig extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletConfig config=getServletConfig();
		String paramName=config.getInitParameter("name");//declared param name and value into web.xml
		PrintWriter printWriter=resp.getWriter();
		resp.setContentType("text/html");
		printWriter.println("<html>");
		printWriter.println("<body>");
		printWriter.println("<h3>Name Value in Config is ::"+paramName+" </h3>");
		printWriter.println("</body>");
		printWriter.println("</html>");
		
	}
}
