package com.spring.julemployeeh2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.julemployeeh2.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    
}
