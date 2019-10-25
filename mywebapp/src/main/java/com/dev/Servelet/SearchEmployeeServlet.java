package com.dev.Servelet;

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

@WebServlet("/searchemp")
public class SearchEmployeeServlet extends HttpServlet{

	EmployeeDAOJpaImpl dao=new EmployeeDAOJpaImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession=req.getSession(false);
		if(httpSession !=null)
		{

			//Get Form Data
			int id=Integer.parseInt(req.getParameter("empid"));
			
			EmployeeInfoBean bean=dao.searchEmployee(id);
			
			resp.setContentType("text/html");
			PrintWriter printWriter=resp.getWriter();
			printWriter.println("<html>");
			printWriter.println("<body>");
			if(bean !=null)
			{
				printWriter.println("<h1>Employee Data </h1>");
				printWriter.println("<h2>Name :: "+bean.getName()+" </h2>");
				printWriter.println("<h2>Age :: "+bean.getAge()+"</h2>");
				printWriter.println("<h2>Salary :: "+bean.getSalary()+"</h2>");
				printWriter.println("<h2>Designation :: "+bean.getDesignation()+"</h2>");
			}
			else {
				printWriter.println("<h1>Employee Data Not Found </h1>");
			}
			printWriter.println("</body>");
			printWriter.println("</html>");
		}
		else {
			resp.sendRedirect("./LoginForm.html");
		}
		
		
		
		
	}
}
