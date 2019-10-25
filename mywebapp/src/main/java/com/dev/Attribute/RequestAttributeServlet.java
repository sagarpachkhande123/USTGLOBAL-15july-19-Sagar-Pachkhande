package com.dev.Attribute;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dto.EmployeeInfoBean;


@WebServlet("/requestAttribute")
public class RequestAttributeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeInfoBean bean=new EmployeeInfoBean();
		
		bean.setId(10);
		bean.setAge(22);
		bean.setName("Sagar");
		bean.setDesignation("Developer");
		
		req.setAttribute("employee", bean);
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/requestAttribute2");
		dispatcher.forward(req,resp);
		
		
	}
}
