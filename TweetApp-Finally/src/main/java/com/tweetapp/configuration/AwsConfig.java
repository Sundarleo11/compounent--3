package com.tweetapp.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Properties specific to aws client.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 */

@Component
@ConfigurationProperties(prefix = "aws", ignoreUnknownFields = false)
public class AwsConfig {

    /**
     * Aws access key ID
     */
    private String accessKey;


    /**
     * Aws secret access key
     */
    private String secretKey;

    /**
     * Aws region
     */
    private String region;

    /**
     * dynamodb endpoint
     */
    
    private String endpoint;

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public AwsConfig() {
		super();
	}

	public AwsConfig(String accessKey, String secretKey, String region, String endpoint) {
		super();
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.region = region;
		this.endpoint = endpoint;
	}

	@Override
	public String toString() {
		return "AwsConfig [accessKey=" + accessKey + ", secretKey=" + secretKey + ", region=" + region + ", endpoint="
				+ endpoint + "]";
	}

    

}
