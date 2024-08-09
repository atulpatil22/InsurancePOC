package com.example.insurance_app;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public class S3UploadService {

    private final AmazonS3 amazonS3;

    @Value("${application.bucket.name}")
    private String bucketName;

    public S3UploadService(AmazonS3 amazonS3) {

        this.amazonS3 = amazonS3;

    }

    public void uploadPdf(byte[] pdfData, String fileName) {

        ByteArrayInputStream bais = new ByteArrayInputStream(pdfData);

        PutObjectRequest request = new PutObjectRequest(bucketName, fileName, bais, null);

        amazonS3.putObject(request);

    }

}


