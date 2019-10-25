package com.tyss.usttyspringmvc.controller;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tyss.usttyspringmvc.dto.Employee;

@Controller
@RequestMapping("/hello")
public class HelloWorldController  {
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor=new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String hello(ModelMap map) {
		map.addAttribute("msg", "Hello World!");
		map.addAttribute("msg1", "Sagar!");

		return "index";
	}

	@RequestMapping(path="/info",method=RequestMethod.GET)
	public String getInfo()
	{
		return "info";
	}

	@RequestMapping(path="/info1",method=RequestMethod.GET)
	public String getInfo(@RequestParam("name") String name,@RequestParam("id") int id,ModelMap map)
	{
		map.addAttribute("id", id);
		map.addAttribute("name", name);
		return "info";
	}

	
	
	@RequestMapping(path="/form-page",method=RequestMethod.GET)
	public String getForm()
	{
		return "form";
	}

	@RequestMapping(path="/form",method=RequestMethod.POST)
	public String formData(Employee emp,ModelMap map) {

		map.addAttribute("id",emp.getId());
		map.addAttribute("name", emp.getName());
		map.addAttribute("email", emp.getEmail());
		map.addAttribute("dob", emp.getDob());
		map.addAttribute("password", emp.getPassword());
		return "info";
	}
	
	

	@RequestMapping(path="/add-cookie",method=RequestMethod.GET)
	public String addCookie(HttpServletResponse response,ModelMap map)
	{
		Cookie cookie=new Cookie("name", "SP");
		response.addCookie(cookie);


		map.addAttribute("cookiesmsg", "Cookies Successfully Added into the browser");
		return "cookie";
	}


	//Cookies

	@RequestMapping(path="/get-cookie",method=RequestMethod.GET)
	public String getCookie(@CookieValue(name="name", required=false)String cname,ModelMap map)
	{
		if(cname==null)
		{
			map.addAttribute("cookiesmsg", "Cookies Not Present");
		}
		else {
			map.addAttribute("cookiesmsg", "cookie Value= "+cname);
		}
		return "cookie";
	}

	@RequestMapping(path="/path-param/{id}/{name}/",method=RequestMethod.GET)
	public String getPathValue(@PathVariable("id")int id,
			@PathVariable("name")String name,ModelMap map)
	{
		map.addAttribute("id", id);
		map.addAttribute("name", name);
		return "info";
	}

	@RequestMapping(path="/set-attribute",method=RequestMethod.GET)
	public String setSession(HttpSession session,ModelMap map) {
		Employee employee=new Employee();
		employee.setId(1);
		employee.setName("Sa_R");
		employee.setEmail("sagr@gmail.com");

		employee.setPassword("abc");
		session.setAttribute("emp", employee);


		map.addAttribute("msg","Session Attribute Set");
		return "index";
	}

	@RequestMapping(path="/get-attribute",method=RequestMethod.GET)
	public String getSessionAttribute(ModelMap map,@SessionAttribute(name="emp",required=false)Employee employee)
	{
		if(employee!=null)
		{
			map.addAttribute("msg","Session Got Employee");
		}
		else
		{
			map.addAttribute("msg", "Session not set");
		}
		return "index";
	}

	@RequestMapping(path="/forward",method=RequestMethod.GET)
	public String forward()
	{
		
		return "forward:add-cookie";
	}

	@RequestMapping(path="/redirect",method=RequestMethod.GET)
	public String redirect()
	{
		
		return "redirect:http://www.google.com";
	}



}
