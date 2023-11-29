package com.ust.spring.demo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.spring.demo1.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
	

}
