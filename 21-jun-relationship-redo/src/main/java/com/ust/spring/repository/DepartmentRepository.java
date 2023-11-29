package com.ust.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.spring.entity.Department;

public interface DepartmentRepository extends JpaRepository <Department,Integer> {
    
}
