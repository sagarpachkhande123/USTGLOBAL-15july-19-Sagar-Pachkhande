package com.ustglobal.ustspringbootfinal1.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustglobal.ustspringbootfinal1.dto.Task;
import com.ustglobal.ustspringbootfinal1.repository.TaskRepository;

@Service("jpa")
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repository;

	@Override
	public boolean addTask(Task task) {
		Date date=new Date();
		task.setTask_start_date(date);
		repository.save(task);
		return true;
	}

	@Override
	public boolean removeTask(int task_id) {
		repository.deleteById(task_id);
		return true;
	}

	@Override
	public boolean modifyTask(Task task) {
		Date date=new Date();
	
		repository.update(date, task.getTask_id());
		return true;
	}

	@Override
	public Task getTask(int task_id) {
		return repository.findById(task_id).get();

	}

	@Override
	public List<Task> getAllTask() {

		return repository.findAll();
	}

}
