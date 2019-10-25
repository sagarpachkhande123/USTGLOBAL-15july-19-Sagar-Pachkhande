package com.dev.Servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@WebServlet("/myFirstServlet")
public class MyFirstServlet extends HttpServlet {

	public MyFirstServlet() {
		System.out.println("Instantiation");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Initilization");
	}
	@Override
	public void destroy() {
		System.out.println("Destroy");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	

		Date date =new Date();
		int a=0;

		resp.setContentType("text/html");
		resp.setHeader("refresh", "1");		//refresh webpage at every 1 seconds
		PrintWriter pw=resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta http-equiv=\"refresh\" content=\"1\">");
		pw.println("</head>");
		pw.println("<body>");

		pw.println("<h1>Current System Date and Time is</br>");

		pw.println(date);

		pw.println("</h1>");

		pw.println("</body>");

		pw.println("</html>");
		pw.close();
	}
}
