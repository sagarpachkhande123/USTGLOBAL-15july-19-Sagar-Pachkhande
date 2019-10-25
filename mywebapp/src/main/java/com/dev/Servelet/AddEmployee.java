package com.dev.Servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.dao.EmployeeDAOJpaImpl;
import com.dev.dto.EmployeeInfoBean;
@WebServlet("/addemployee")
public class AddEmployee extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession=req.getSession(false);

		if(httpSession!=null){
			int empid=Integer.parseInt(req.getParameter("empid"));
			String empname=req.getParameter("empname");
			int empage=Integer.parseInt(req.getParameter("empage"));
			double empsalary=Double.parseDouble(req.getParameter("empsalary"));
			String designation=req.getParameter("empdesignation");

			EmployeeInfoBean bean=new EmployeeInfoBean();
			bean.setId(empid);
			bean.setName(empname);
			bean.setSalary(empsalary);
			bean.setAge(empage);
			bean.setDesignation(designation);

			resp.setContentType("text/html");
			PrintWriter printWriter=resp.getWriter();
			printWriter.println("<html>");
			printWriter.println("<body>");

			EmployeeDAOJpaImpl daoJpaImpl=new EmployeeDAOJpaImpl();

			if(daoJpaImpl.addEmployee(bean))
			{
				printWriter.println("<h1>Employee Successfully added into Database </h1>");
				printWriter.println(bean.getId());
			}
			else {
				printWriter.println("<h1>Employee could not be added into Database </h1>");
			}
		}
		else {
			resp.sendRedirect("./LoginForm.html");
		}
	}
}
