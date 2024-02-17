# LSDS2021-seed
The s3 bucket has been created. To share the bucker we had to follow the following commands:
(insert commands)

# 1.- Objective of the lab
To correctly execute the lab, call the jar with the following arguments:
java -jar target/jarfile [language] [output file] [bucket] [file(s)]
- language: es/en/ca the language of tweets to process and filename inside the bucket
- output file: filename in which to write the processed data locally
- bucket: bucket name to which upload data
- file(s): multiple arguments accepted, collection of files to be processed

Obviously the TwitterFilter class is callable, as it contains the application's main method.
To connect to the bucket, the **[default] credentials** in the aws configuration and credentials files are used. Please make sure to run
'aws configure' and 'aws configure set aws_session_token' before program execution and that the user has access and writing permissions to the specified bucket.

# 2.- Parsing JSON: SimplifiedTweet.java

To create an optional of type SimplifiedTweet, the following criteria is checked:
- The passed jsonStr is of a valid json format
- The passed jsonStr contains all specified attributes of type Long
(String attributes are nullable, while Long attributes are assigned to -1 if missing to avoid java nullpointer exceptions)
- Discard the tweet if some String attribute is missing during mapping

Failure to meet any of these criteria will result in an empty optional.
The toString() method has been implemented using the Gson's library functions

# 3.- Filter Class: FileLanguageFilter.java

Part of the lab responsible of filtering from the input file the tweets based on the specified language and writing the filtered tweets to an output file. 
Filter Class uses:
- Language Filtering: Tweets are filtered based on the specified language (es, en, or ca). Only the tweets in the specified language are not discarded.
- Input and Output Files: Class reads tweet data from input files, processes each tweet, and writes the filtered tweets to an output file. 
- Exception Handling: To handle potential errors during file reading, writing, and tweet processing. Any encountered exceptions are appropriately handled and reported.


# 4.- Implement an uploader: S3Uploader.java

The program can recieve a series of files (though functionally it only has to process the single output file generated) and loads the 
contents of the file to a String in memory which will then be uploaded to the specified bucket with a key of (bucket)/(language), using the default
credentials in the aws config file. If the user has no permissions to write to the bucket an exception will be thrown.

# 5.- Benchmarking



# 6.- Extensions: TwitterFilterTest.java

The unit tests have been conducted using a few examples of tweets from the Eurovision 2018 collection, the following cases are checked:
- Processing a sample valid tweet containing the necessary data results in an Optional of type SimplifiedTweet
- Processing a json that is completly unrelated results in an empty optional
- Processing a sample (otherwise valid) tweet containing all the necessary attributes EXCEPT FOR 1 ('id') results in an empty optional.

These tests are checked at compile time, so maven makes sure automatically that they all pass before the application is ran. Were they to fail, no target folder would be generated.
