package com.dev.ServletRedirecting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/includeServlet")
public class IncludeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher=req.getRequestDispatcher("/openpage.html");
		dispatcher.include(req, resp);
		
		PrintWriter printWriter=resp.getWriter();
		resp.setContentType("text/html");
		printWriter.println("<html>");
		printWriter.println("<body>");
		printWriter.println("<h3>This is Include Servlet Before </h3>");
//		RequestDispatcher dispatcher=req.getRequestDispatcher("/myFirstServlet");
//		dispatcher.include(req, resp);
	
		printWriter.println("<h3>This is Include Servlet After </h3>");
		printWriter.println("</body>");	
		printWriter.println("</html>");	
}
}