package edu.upf.uploader;

import java.util.List;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class S3Uploader implements Uploader {


    final String BucketName;
    final String prefix;
    final AmazonS3 s3;

    public S3Uploader(String BucketName, String prefix, String accessKey, String secretKey, String sessionToken) {
        BasicSessionCredentials awsCreds = new BasicSessionCredentials(accessKey, secretKey, sessionToken);
        s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
        this.BucketName = BucketName;
        this.prefix = prefix;
    }
    @Override
    public void upload(List<String> files) { //should only take one file, otherwise last file overwrites all previous in the bucket (all use the same key)
        for (String file : files) {
            try {
                s3.putObject(BucketName, prefix, file);
            } catch (AmazonServiceException e) {
                System.err.println(e.getErrorMessage());
                System.exit(1);
            }
        }
    }
}
