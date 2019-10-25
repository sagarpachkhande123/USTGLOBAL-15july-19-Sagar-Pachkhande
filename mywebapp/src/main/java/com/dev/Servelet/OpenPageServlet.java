package com.dev.Servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/homepage")
public class OpenPageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession=req.getSession(false);
		if(httpSession!=null)
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("/openpage.html");
			dispatcher.forward(req,resp);
			
		}
		else {
			RequestDispatcher dispatcher=req.getRequestDispatcher("/LoginForm.html");
			dispatcher.forward(req,resp);
		}
	
	}
}
