package com.tyss.usttyspringrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.usttyspringrest.dto.Employee;
import com.tyss.usttyspringrest.dto.EmployeeResponse;
import com.tyss.usttyspringrest.service.EmployeeService;

@RestController

@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	EmployeeResponse response=new EmployeeResponse();
	@GetMapping(path="/get",produces=MediaType.APPLICATION_JSON_VALUE)

	public EmployeeResponse getEmployee(@RequestParam("id")int id)
	{
		Employee employee=service.getEmployee(id);
		if(employee==null)
		{
			response.setStatuscode(401);
			response.setMessage("Failed..");
			response.setDescription("No data Found..");
		}
		else {
			response.setStatuscode(201);
			response.setMessage("Success..");
			response.setDescription("Data found..");
			response.setEmployees(Arrays.asList(employee));
		}
		return response;
	}

	@GetMapping(path="/get-all",produces=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getAllEmployee(){
		List<Employee> employees=service.getAllEmployees();
		if(employees==null)
		{
			response.setStatuscode(401);
			response.setMessage("Failed..");
			response.setDescription("No data Found..");
		}
		else {
			response.setStatuscode(201);
			response.setMessage("Success..");
			response.setDescription("Data found..");

		}

		return response;
	}

	@PostMapping(path="/add",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)

	public EmployeeResponse addEmployee(@RequestBody Employee employee)
	{
		if(service.addEmployee(employee))
		{
			response.setStatuscode(201);
			response.setMessage("Successful..");
			response.setDescription("Data Added into DB");
		}
		else {
			response.setStatuscode(401);
			response.setMessage("Failure..");
			response.setDescription("Data Failed to add..");
		}
		return response;


	}

	@PutMapping(path="/modify",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse modifyEmployee(@RequestBody Employee employee)
	{
		if(service.modifyEmployee(employee))
		{
			response.setStatuscode(201);
			response.setMessage("Successful..");
			response.setDescription("Data Modified having id= "+employee.getId());
		}
		else {
			response.setStatuscode(401);
			response.setMessage("Failure..");
			response.setDescription("Data Not Modified");
		}
		return response;
	}
	@DeleteMapping(path="/remove/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse removeEmployee(@PathVariable("id")int id)
	{
		if(service.removeEmployee(id))
		{
			response.setStatuscode(201);
			response.setMessage("Successful..");
			response.setDescription("Data Deleted..");
		}
		else {
			response.setStatuscode(401);
			response.setMessage("Failure..");
			response.setDescription("Data Not Deleted");
		}
		return response;
	}
}	
