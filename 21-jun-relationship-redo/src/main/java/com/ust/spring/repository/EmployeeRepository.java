package com.ust.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.spring.entity.Employee;

public interface EmployeeRepository extends JpaRepository <Employee,Integer>{
     
}
