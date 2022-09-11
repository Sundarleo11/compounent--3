package com.tweetapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.model.Login;
import com.tweetapp.model.User;
import com.tweetapp.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	
	public String registerUser(User user) throws Exception {
		
		User usr =loginRepository.saveUser(user);
		if(usr.getUsername()!=null) {
			return "registered!";
		}
		return null;
	}
	

	public User login(Login login) throws Exception {
		
		User user =null;
		try {
		user = loginRepository.getUserByEmail(login);
		
		if(user == null || !user.getEmail().equals(login.getEmail()) || !user.getPassword().equals(login.getPassword())) {
			
			throw new Exception("Please check your crdentials!");
		}
		
		user.setStatus(1);
		
		
		return loginRepository.saveUser(user);
		}catch(Exception e) {
			throw new Exception("Please check your crdentials!");
		}
		
	}
	
	public String logout(String email) throws Exception {
		User userList = loginRepository.findByEmail(email);
		
		if(userList == null) {
			throw new Exception("We couldn't find your email");
		}
		
		userList.setStatus(0);
		loginRepository.saveUser(userList);
		
		return "logged out";
	}
	
	public List<User> getAllUsers(){
		
		List<User> userLists = loginRepository.findAll();
		
		return userLists;
	}
	
	public User getUsersByName(String username) {
		
		User userLists = loginRepository.findByEmail(username);
		
		return userLists;
	}
	
	public User forgetPassword(String email) throws Exception {
		
		User userList = loginRepository.findByEmail(email);
		
		if(userList == null) {
			throw new Exception("Please check your email!");
		}
		
		return userList;
	}
	
	public User updateUser(Login login) {
		
		User userList = loginRepository.findByEmail(login.getEmail());
		
		userList.setPassword(login.getPassword());

		return loginRepository.saveUser(userList);
	}
	
	
}
