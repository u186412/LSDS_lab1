package spark;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;
import scala.Tuple2;

import java.util.Arrays;

import edu.upf.filter.FileLanguageFilter;

public class TwitterLanguageFilterApp {
    public static void main(String[] args){
        String input = args[0];
        String outputDir = args[1];
        String language = args[2]; // language tat will filter

        // Create a SparkContext to initialize
        SparkConf conf = new SparkConf().setAppName("Word Count with Twitter Language Filter App");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);

        try {
            // Init FileLanguageFilter to filter tweets by language
            FileLanguageFilter languageFilter = new FileLanguageFilter(input, outputDir);
            languageFilter.filterLanguage(language); // Filter tweets by language

            // Load filtered tweets, reads all in outputDir and returns a RDD<String> with content concatenated
            JavaRDD<String> sentences = sparkContext.textFile(outputDir);

            // Word count
            JavaPairRDD<String, Integer> counts = sentences
                .flatMap(s -> Arrays.asList(s.split("[ ]")).iterator())
                .map(word -> normalise(word))
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b);
            
            System.out.println("Total words: " + counts.count());
            counts.saveAsTextFile(outputDir);
        } catch (Exception e) {
            // if an exeption occurs, throw a new exception with a meaningfull message
            throw new Exception("Error occurred while filtering tweets: " + e.getMessage());
        }
    }

    private static String normalise(String word) {
        return word.trim().toLowerCase();
    }
}


    
