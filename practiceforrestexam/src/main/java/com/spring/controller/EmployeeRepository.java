package com.spring.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
