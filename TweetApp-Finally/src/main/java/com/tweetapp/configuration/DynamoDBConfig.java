package com.tweetapp.configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import lombok.RequiredArgsConstructor;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
@EnableDynamoDBRepositories(basePackages = "com.tweetapp.repository")
public class DynamoDBConfig {

	@Autowired
    private AwsConfig config;
	
	String accessKey = "AKIAXYUQM46ZVI4SQMT4";
	String secretKey = "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";
	String region = "us-east-1";
	String endPoint ="dynamodb.us-east-1.amazonaws.com";


    public AWSCredentialsProvider amazonAWSCredentialsProvider() {
    	
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey));
    }

    @Bean
    public DynamoDBMapperConfig dynamoDBMapperConfig() {
        return DynamoDBMapperConfig.DEFAULT;
    }

    @Bean
    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
        return new DynamoDBMapper(amazonDynamoDB, config);
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider())
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, region))
                .build();
    }
}
