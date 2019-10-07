package com.ustglobal.ustspringbootfinal1.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ustglobal.ustspringbootfinal1.dto.Task;
import com.ustglobal.ustspringbootfinal1.dto.TaskResponse;
import com.ustglobal.ustspringbootfinal1.service.TaskService;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class TaskController {

	@Autowired
	@Qualifier("jpa")
	private TaskService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);

	}// End of initBinder()
	
	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public TaskResponse getTask(@RequestParam("task_id") int task_id) {
		Task task = service.getTask(task_id);
		TaskResponse response = new TaskResponse();
		if (task == null) {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("data not found in DB");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data found in DB!!!");
			response.setTasks(Arrays.asList(task));

		}

		return response;

	}// End of getTask()

	@GetMapping(path = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
	public TaskResponse getAllTask() {
		List<Task> task = service.getAllTask();
		TaskResponse response = new TaskResponse();
		if (task == null) {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("data not found in DB");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data found in DB!!!");
			response.setTasks(task);

		}

		return response;

	}// End of getAllTask()

	@PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TaskResponse addEmployee(@RequestBody Task task) {

		TaskResponse response = new TaskResponse();
		if (service.addTask(task)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data added into db!!!");
			response.setTasks(Arrays.asList(task));

		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("data not added");
		}

		return response;

	}// end of addTask()

	@PutMapping(path = "/modify", produces = MediaType.APPLICATION_JSON_VALUE)
	public TaskResponse modifyTask(@RequestBody Task task) {

		TaskResponse response = new TaskResponse();
		if (service.modifyTask(task)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data modify!!!");
			response.setTasks(Arrays.asList(task));
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("data not modify");
		}

		return response;

	}// end of modifyTask()

	@DeleteMapping(path = "/remove/{task_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TaskResponse deleteEmployee(@PathVariable("task_id") int task_id) {

		TaskResponse response = new TaskResponse();
		if (service.removeTask(task_id)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("removed!!!");

		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("not removed");
		}

		return response;

	}// end of deleteTask()

}
