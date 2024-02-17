package edu.upf.filter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import edu.upf.parser.SimplifiedTweet;

public class FileLanguageFilter implements LanguageFilter{
    final String inputFile;
    final String outputFile;

    public FileLanguageFilter(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }
    
    @Override
    public void filterLanguage(String language) throws Exception {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            //Read each line from the input file 
            String jline;
            while ((jline = reader.readLine()) != null){
                Optional<SimplifiedTweet> optionalTweet = SimplifiedTweet.fromJson(jline);

                if (optionalTweet.isPresent() && optionalTweet.get().getLanguage().equals(language)) {
                    // Write the SIMPLIFIED tweet to the output file
                    writer.write(optionalTweet.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            // If an IO exception occurs, throw a new exception with a meaningful message
            throw new Exception("Error occurred while filtering tweets: " + e.getMessage());
        } 
    }
}

