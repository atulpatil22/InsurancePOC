package com.example.insurance_app;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsuranceConfig {



    @Bean
    public AmazonS3 s3() {

      //  String awsAccessKey = System.getenv("awsAccessKey");
     //   String awsSecretKey = System.getenv("awsSecretKey");


     //   AWSCredentials awsCreds = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
     //   System.out.println(awsCreds);
      //  return AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).
       //         withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

        return AmazonS3ClientBuilder.standard().withRegion(Regions.AP_SOUTH_1)
                .build();
    }
}


