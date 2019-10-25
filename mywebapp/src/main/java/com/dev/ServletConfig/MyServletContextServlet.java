package com.dev.ServletConfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mycontext")
public class MyServletContextServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		ServletContext context=getServletContext();
		String myparamName=context.getInitParameter("mycontextname");
		PrintWriter printWriter=resp.getWriter();
		resp.setContentType("text/html");
		printWriter.println("<html>");
		printWriter.println("<body>");
		printWriter.println("<h3>Name Value in Context is ::"+myparamName+" </h3>");
		printWriter.println("</body>");
		printWriter.println("</html>");
	}
	
}
