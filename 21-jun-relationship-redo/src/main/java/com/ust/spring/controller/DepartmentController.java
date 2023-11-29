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

import com.ust.spring.entity.Department;
import com.ust.spring.repository.DepartmentRepository;


class  DepartmentAlreadyExistsException extends RuntimeException{
    public DepartmentAlreadyExistsException(String message){
        super(message);
    }
}

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
        private DepartmentRepository dr;

        @PostMapping
        public Department addDepartment(@RequestBody Department department){
            System.out.println("department");
            if(department.getId()==null){
               return dr.save(department);
            }
            Department temp=findDepartmentById(department.getId());
            if(temp==null)
            {
                dr.save(department);
            }
            else{
                throw new DepartmentAlreadyExistsException("the given id");
            }
            return temp;
        }

        @GetMapping("/{id}")
        public Department findDepartmentById(@PathVariable("id") Integer id){
            Optional<Department>temp=dr.findById(id);
            Department department=null;
            if(temp.isPresent())
            {
                department=temp.get();
            }
            return department;
        }

        @GetMapping
        public List<Department>retrieveAllDepartment(){
            return dr.findAll();
        }

        @PutMapping("/{id}")
        public Department updateDepartment(@PathVariable("id") Integer id, @RequestBody Department department){
            Department existing =findDepartmentById(id);
            if(existing!=null)
            {
                existing=department;
                dr.save(existing);
            }
            return existing;
        }

        @DeleteMapping("/{id}")
        public Department deleDepartment(@PathVariable("id") Integer id){
        Department existing=findDepartmentById(id);
        if(existing!=null){
            dr.delete(existing);
        }
            return existing;
        }
}
