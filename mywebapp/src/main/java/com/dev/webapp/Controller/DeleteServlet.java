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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("Id"));

		EmployeeDAO dao=new EmployeeDAOJpaImpl();
		dao.deleteEmployee(id);
		HttpSession httpSession=req.getSession(false);
		if(httpSession!=null) {
			httpSession.invalidate();
		}
		resp.sendRedirect("./loginJSP");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

	}
}
