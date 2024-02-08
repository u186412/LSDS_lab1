package edu.upf.filter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Optional;
import edu.upf.parser.SimplifiedTweet;


public class FileLanguageFilter {
    final String inputFile;
    final String outputFile;

    public FileLanguageFilter(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }
    public void filterLanguage(String language) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) { 
                Optional<SimplifiedTweet> optionalTweet = SimplifiedTweet.fromJson(line);
                
                if (optionalTweet.isPresent()) {
                    SimplifiedTweet tweet = optionalTweet.get();
                    
                    if (tweet.getLanguage().equals(language)) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
        }
    }
}
