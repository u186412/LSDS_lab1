package edu.upf.uploader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class S3Uploader implements Uploader {


    final String BucketName;
    final String prefix;
    final AmazonS3 s3;

    public S3Uploader(String BucketName, String prefix) {
        s3 = AmazonS3ClientBuilder.standard()
                .build();
        this.BucketName = BucketName;
        this.prefix = prefix;
    }
    @Override
    public void upload(List<String> files) { //should only take one file, otherwise last file overwrites all previous in the bucket (all use the same key)
        for (String file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder contentBuilder = new StringBuilder();
                String line;
                // Read each line from the file and append to StringBuilder
                while ((line = reader.readLine()) != null) {
                    contentBuilder.append(line).append("\n");
                }
                // Convert StringBuilder to String
                String content = contentBuilder.toString();
                try {
                    s3.putObject(BucketName, prefix, content);
                } catch (AmazonServiceException e) {
                    System.err.println(e.getErrorMessage());
                    System.exit(1);
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
