package com.ust.spring.controller;

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

import com.ust.spring.entity.Employee;
import com.ust.spring.repository.EmployeeRepository;
class EmployeeAlreadyExistsException extends RuntimeException{
    public EmployeeAlreadyExistsException(String message)
    {
        super(message);
    }
}

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository er;
    
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
    System.out.println(employee);
    if(employee.getId()==null){
        return er.save(employee);
    }
    Employee temp=findEmployeeById(employee.getId());
    if(temp==null){
        er.save(temp);
    }
    else{
        throw new EmployeeAlreadyExistsException("The employee  with id" + employee.getId() + "Already exists");
    }

    return employee;
   }


   @GetMapping("/{id}")
   public Employee findEmployeeById(@PathVariable("id")Integer id){
       Optional <Employee>temp=er.findById(id);
       Employee employee=null;
       if(temp.isPresent()){
           employee=temp.get();
       }
       return employee;
   }

   @GetMapping
   public  List<Employee>retrieveAllEmployees(){
     return  er.findAll();
   }


    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee){
        Employee existing = findEmployeeById(id);
        if(existing!=null){
            existing=employee;
            er.save(existing);
        }
        return existing;
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable("id") Integer id){
        Employee existing = findEmployeeById(id);
        if(existing!=null){
            er.delete(existing);
        }
        return existing;
    }
}
