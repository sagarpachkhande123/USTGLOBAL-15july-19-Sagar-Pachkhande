package com.dev.webapp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.dao.EmployeeDAO;
import com.dev.dao.EmployeeDAOJpaImpl;
import com.dev.dto.EmployeeInfoBean;

@WebServlet("/loginJSP")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher=req.getRequestDispatcher("./login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id=Integer.parseInt(req.getParameter("Id"));
		String password=req.getParameter("password");
		
		EmployeeDAO dao=new EmployeeDAOJpaImpl();
		EmployeeInfoBean bean=dao.login(id, password);
		
		String url=null;
		if(bean!=null)
		{
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("bean", bean);
			url="/home.jsp";
		}
		else {
			url="/login.jsp";
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}
}
