package com.ust.spring.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.ust.spring.entity.MyUser;

@RestController
public interface UserRepository extends JpaRepository<MyUser, String> {
	
}
