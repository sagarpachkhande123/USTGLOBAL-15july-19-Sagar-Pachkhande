package com.dev.ServletRedirecting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forwardServlet")
public class ForwardServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String url="http://localhost:8081/mywebapp/welcome";
		
			RequestDispatcher dispatcher=req.getRequestDispatcher("/redirect");
			dispatcher.forward(req,resp);
	
	}
}
