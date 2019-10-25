package com.dev.webapp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.EmployeeDAO;
import com.dev.dao.EmployeeDAOJpaImpl;
import com.dev.dto.EmployeeInfoBean;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher=req.getRequestDispatcher("./Register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		int id=Integer.parseInt(req.getParameter("Id"));
		String password=req.getParameter("password");
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		double salary=Double.parseDouble(req.getParameter("salary"));
		String designation=req.getParameter("designation");
		
		EmployeeInfoBean bean=new EmployeeInfoBean();
		bean.setId(id);
		bean.setName(name);
		bean.setAge(age);
		bean.setSalary(salary);
		bean.setDesignation(designation);
		bean.setPassword(password);
		
		EmployeeDAOJpaImpl daoJpaImpl=new EmployeeDAOJpaImpl();
		daoJpaImpl.addEmployee(bean);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("./login.jsp");
		dispatcher.forward(req, resp);
	}
	
}
