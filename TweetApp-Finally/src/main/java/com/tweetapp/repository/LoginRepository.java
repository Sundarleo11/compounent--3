package com.tweetapp.repository;


import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.tweetapp.model.Login;
import com.tweetapp.model.User;

@EnableScan
@Repository
public class LoginRepository{
	
	@Autowired
    private DynamoDBMapper dynamoDBMapper;
	
	public User saveUser(User user) {
		dynamoDBMapper.save(user);
		return user;
	}
	
	public User getUserByEmail(Login login) throws Exception {
		
		
		try {
		User user =dynamoDBMapper.load(User.class,login.getEmail());
		
		System.out.println("User "+user);
		return user;
		}catch(Exception e) {
			throw new Exception("Please check your credentials!");
		}
		
	}
	
	public User findByEmail(String email) {
		
		User user =dynamoDBMapper.load(User.class,email);
		
		
		return user;
	}
	
	public List<User> findAll(){
		List<User> userList = dynamoDBMapper.scan(User.class, new DynamoDBScanExpression());
		
		return userList;
	}


}
