package com.tweetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;

@SpringBootApplication(exclude={SolrAutoConfiguration.class})
public class TweetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetAppApplication.class, args);
		
	}
	

}
