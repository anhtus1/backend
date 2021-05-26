package com.in28minutes.rest.webServices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//biến class thành controller
@RestController

// để localhost frontend giao tiếp với local host backend
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldController {
	
	
	//GET
	//URI - /helloworld
	//method - "Hello World"
	// map phương thức get to URI
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}

	///hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
		//throw new RuntimeException("Something went wrong");
	}
	
}
