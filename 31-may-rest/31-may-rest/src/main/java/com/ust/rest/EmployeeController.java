package com.ust.rest;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.model.Employee;
import com.ust.rest.model.EmployeeRepository;



@RestController
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository er;
	
	@GetMapping
	public List<Employee> retrieveAllEmployees()
	{
		return er.findAll();
	}
	
	//find Employee by id
	
	@GetMapping("/{id}")
	public Employee findEmployeeById(@PathVariable("id") Integer id)
	{
		Employee emp=null;
		Optional<Employee> temp = er.findById(id);
		if(temp.isPresent())
			emp=temp.get();
		return emp;
	}
	
	@GetMapping("/name/{name}")
	public List<Employee> findEmployeesByName(@PathVariable("name")String name){
		return er.findByName(name);
	}
	
	@GetMapping("/department/{department}")
	public List<Employee> findEmployeesByDepartment(@PathVariable("department")String department) {
		return er.findByDepartment(department);
	}  
	
	
	
	@GetMapping("/name/{name}/department/{department}")
	public List<Employee> findByNameAndDepartment(@PathVariable("name")String name, @PathVariable("department")String department)
	{
		return er.findByNameAndDepartment(name, department);
	}
	
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return er.save(employee);
	}
	
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee)
	{//we will improvise this later
		return er.save(employee);
	}
	
	@DeleteMapping("/{id}")
	public Employee deleteEmployee(@PathVariable("id") Integer id)
	{
		Employee emp = findEmployeeById(id);
		if(emp!=null)
		{
			er.delete(emp);
		}
		return emp;
	}
}


