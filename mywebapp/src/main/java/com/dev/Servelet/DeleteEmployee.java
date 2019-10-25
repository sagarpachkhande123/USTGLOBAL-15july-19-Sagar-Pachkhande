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

@WebServlet("/deleteemployee")
public class DeleteEmployee extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession=req.getSession(false);
		if(httpSession !=null)
		{
		int eid=Integer.parseInt(req.getParameter("empid"));
		
		EmployeeDAOJpaImpl daoJpaImpl=new EmployeeDAOJpaImpl();
		
		resp.setContentType("text/html");
		PrintWriter printWriter=resp.getWriter();
		printWriter.println("<html>");
		printWriter.println("<body bgcolor=\"#f2f2f2\">");
		if(daoJpaImpl.deleteEmployee(eid))
		{
			printWriter.println("<center><h1>Employee Successfully Deleted from Database </h1>");
		}
		else {
			printWriter.println("<h1>Employee with Empoloyee Id:: "+eid+" <br>could not be found</h1></center>");
		}
		printWriter.println("</body>");
		printWriter.println("</html>");
		}
		else {
			resp.sendRedirect("./LoginForm.html");
		}
		
	}
}
