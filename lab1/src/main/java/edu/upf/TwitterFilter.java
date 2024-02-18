package edu.upf;

import edu.upf.filter.FileLanguageFilter;
import edu.upf.uploader.S3Uploader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TwitterFilter {
    public static void main( String[] args ) throws Exception {
        long startTime = System.currentTimeMillis();

        //store necessary parameters
        List<String> argsList = Arrays.asList(args);
        if (argsList.size() < 4) {
            System.out.println("Please provide the necessary input parameters: language, outputFile, bucket, files");
            System.exit(0);
        }
        String language = argsList.get(0);
        String outputFile = argsList.get(1);
        String bucket = argsList.get(2);
        //identify files to process
        List<String> files = new ArrayList<>();
        for (int i = 3; i < argsList.size(); i++) {
            files.add(argsList.get(i));
        }

        System.out.println("Language: " + language + ". Output file: " + outputFile + ". Destination bucket: " + bucket);
        
        // Initialize a counter for total tweets processed
        int totalTweetsProcessed = 0;
        for(String inputFile: files) {
            System.out.println("Processing: " + inputFile);
            final FileLanguageFilter filter = new FileLanguageFilter(inputFile, outputFile);
            
            filter.filterLanguage(language);

            // Retrieve the number of tweets processed for the current file
            int tweetsProcessed = filter.getTweetsFiltered();
            System.out.println("Tweets processed in " + inputFile + ": " + tweetsProcessed);

            // Update the total number of tweets processed
            totalTweetsProcessed += tweetsProcessed;
         }


        final S3Uploader uploader = new S3Uploader(bucket, language);
        uploader.upload(Arrays.asList(outputFile));

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total running time is: " + totalTime + " milliseconds");
        System.out.println("Total tweets processed in "+ language + " are: " + totalTweetsProcessed);    }
}
