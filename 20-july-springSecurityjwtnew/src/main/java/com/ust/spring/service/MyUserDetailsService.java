package com.ust.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ust.spring.model.MyUser;
import com.ust.spring.model.MyUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private MyUserRepository mur;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<MyUser>temp=mur.findById(username);
		if(temp.isPresent())
		{
			return temp.get();
		}
		return null;
	}
	
	public MyUser create(MyUser myUser) {
		return mur.save(myUser);
	}

}
