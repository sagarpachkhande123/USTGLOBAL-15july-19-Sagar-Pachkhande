package com.dev.Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.dao.EmployeeDAO;
import com.dev.dao.EmployeeDAOJpaImpl;
import com.dev.dto.EmployeeInfoBean;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	EmployeeDAO dao=new EmployeeDAOJpaImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empId=Integer.parseInt(req.getParameter("empId"));
		String password=req.getParameter("password");
		
		EmployeeInfoBean bean=dao.login(empId, password);
		
		if(bean !=null)
		{
			HttpSession httpSession=req.getSession(true);
			httpSession.setAttribute("employeeInfo", bean);
			resp.sendRedirect("./openpage.html");
			
		}
		else {
			resp.sendRedirect("./LoginForm.html");
		}
	}//End of doPost()
}//End of Class
