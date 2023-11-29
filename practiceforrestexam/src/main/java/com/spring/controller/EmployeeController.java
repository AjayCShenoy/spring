package com.spring.controller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Employee;

class AlreadyExistsException extends RuntimeException{
   public AlreadyExistsException(String msg){
       super(msg);
   }
}
@RestController
@RequestMapping("/employeee" )
public class EmployeeController{

@Autowired
private EmployeeRepository er;

@PostMapping
public Employee addEmployee(@RequestBody Employee employee){
    if(employee.getId()==null){
        return er.save(employee);
    }
    Employee emp=findEmployeeById(employee.getId());
    if(emp==null)
    {
        er.save(employee);
    }
    else{
        throw new AlreadyExistsException("already Exists" + employee.getId());
    }
    return employee;
}

@GetMapping

public List<Employee> retrieveAllEmployees(){
   return  er.findAll();
}


@GetMapping("/{id}")
public Employee findEmployeeById(@PathVariable Integer id){
    Optional<Employee> temp = er.findById(id);
    Employee emp =null;
    if(temp.isPresent())
    {
        emp=temp.get();
    }
     return emp;

}

@PutMapping("/{id}")
public Employee  updateEmployee(@PathVariable ("id") Integer id, @RequestBody Employee employee){
    Employee emp=findEmployeeById(id);
    if(emp!=null){
        emp=employee;
        er.save(emp);
    }
    return emp;
}

@DeleteMapping("/{id}")
public Employee deleteEmployee(@PathVariable("id") Integer id){
    Employee emp=findEmployeeById(id);
    if(emp!=null)
    {
        er.delete(emp);
    }
    return emp;
  }
}


