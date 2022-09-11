package com.tweetapp.repository;


import java.util.List;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.tweetapp.model.Tweet;


@EnableScan
@Repository
public class TweetRepository{
	
	@Autowired
    private DynamoDBMapper dynamoDBMapper;
	
	public List<Tweet> findAll() {
		
		List<Tweet> tweets =  dynamoDBMapper.scan(Tweet.class, new DynamoDBScanExpression());

		return tweets;
	}
	
	public List<Tweet> findByEmail(String email) {  
	    DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
	    scanExpression.addFilterCondition("email", new Condition()                                           
	       .withComparisonOperator(ComparisonOperator.EQ)                                                
	       .withAttributeValueList(new AttributeValue().withS(email)));
	    return dynamoDBMapper.scan(Tweet.class, scanExpression);
	}
	
	public Tweet save(Tweet tweet) {
		
		dynamoDBMapper.save(tweet);
		
		return tweet;
	}
	
	public Tweet findByEmailAndId(String email,String id) {
		Tweet tweet = dynamoDBMapper.load(Tweet.class,id);
		return tweet;
	}
	
	public String delete(String id) {
		
		dynamoDBMapper.delete(dynamoDBMapper.load(Tweet.class,id));
		
		return "deleted";
	}


}
