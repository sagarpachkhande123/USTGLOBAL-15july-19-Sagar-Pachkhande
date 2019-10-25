package com.dev.ServletRedirecting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String url="https://www.facebook.com";
		String url="http://localhost:8081/mywebapp/welcome";
		
		resp.sendRedirect(url);
		
		
	}//End of Doget()
}//End of Servlet
