package com.dev.Servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addcookies")
public class CreateCookiesServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie cookie=new Cookie("name", "pachkhande");
		Cookie cookie1=new Cookie("name1", "sagar");
		resp.addCookie(cookie);
		resp.addCookie(cookie1);
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		out.println("<html>");
		out.println("<body>");
		
		out.println("<h2>Cookies Created Successfully!</h2>");
		out.println("</body>");
		out.println("</html>");
	}
}
