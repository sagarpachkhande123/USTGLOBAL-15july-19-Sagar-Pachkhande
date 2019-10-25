package com.dev.Servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readcookies")
public class ReadCookiesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie [] cookies=req.getCookies();

		PrintWriter printWriter=resp.getWriter();
		resp.setContentType("text/html");
		printWriter.println("<html>");
		printWriter.println("<body>");
		if(cookies!=null) {
			for(Cookie cookie: cookies)
			{
				printWriter.println("<h2>Cookie Name::"+cookie.getName()+"<br>Cookie Value::"+cookie.getValue()+"</h2>" );
			}
		}

		printWriter.println("</body>");
		printWriter.println("</html>");


	}
}
