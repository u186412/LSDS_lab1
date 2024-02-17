package edu.upf;

import edu.upf.filter.FileLanguageFilter;
import edu.upf.uploader.S3Uploader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TwitterFilter {
    public static void main( String[] args ) throws Exception {
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
        for(String inputFile: files) {
            System.out.println("Processing: " + inputFile);
            final FileLanguageFilter filter = new FileLanguageFilter(inputFile, outputFile);
            filter.filterLanguage(language);
        }

        final S3Uploader uploader = new S3Uploader(bucket, language);
        uploader.upload(Arrays.asList(outputFile));
    }
}
