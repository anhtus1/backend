package com.in28minutes.rest.webServices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodeService {
	private static List<Todo> todos = new ArrayList();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "in28minutes", "Learn to Dance 2", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn about Microservices2", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn about Angular 3", new Date(), false));
	}
	
	public List<Todo> findAll() {
		return todos;
	}
	
	
	
	public Todo save(Todo todo) {
		if (todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	//b1
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if(todo==null) return null;
		if (todos.remove(todo)) {
			// tạo equal trong class todo
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
