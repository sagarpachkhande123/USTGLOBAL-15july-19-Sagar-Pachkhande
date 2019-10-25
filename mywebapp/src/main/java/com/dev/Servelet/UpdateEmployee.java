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

@WebServlet("/updateemployee")
public class UpdateEmployee extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		HttpSession httpSession=req.getSession(false);
		if(httpSession !=null)
		{
			int id=Integer.parseInt(req.getParameter("empid"));

			String name=req.getParameter("empname");

			EmployeeDAOJpaImpl daoJpaImpl=new EmployeeDAOJpaImpl();

			resp.setContentType("text/html");
			PrintWriter printWriter=resp.getWriter();
			printWriter.println("<html>");
			printWriter.println("<body>");

			if(daoJpaImpl.UpdateEmployee(id, name))
			{

				printWriter.println("<h1>Employee with Empoloyee Id:: "+id+"  Successfully Updated </h1>");
				printWriter.println("<h1>After Modification Name:: "+name+"</h3>");
			}
			else {
				printWriter.println("<h1>Employee with Empoloyee Id:: "+id+" <br>could not be found</h1>");
			}
			printWriter.println("</body>");
			printWriter.println("</html>");
		}
		else {
			resp.sendRedirect("./LoginForm.html");
		}
	}
}