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

# 3.- Filter Class



# 4.- Implement an uploader: S3Uploader.java

The program can recieve a series of files (though functionally it only has to process the single output file generated) and loads the 
contents of the file to a String in memory which will then be uploaded to the specified bucket with a key of (bucket)/(language), using the default
credentials in the aws config file. If the user has no permissions to write to the bucket an exception will be thrown.

# 5.- Benchmarking
The operating system we used to run this is a macOS Sonoma 14.3, with a memory of 8GB.

To execute it we used: java -cp target/lab1-1.0-SNAPSHOT.jar edu.upf.TwitterFilter [language] output.txt lsds2024.lab1.output.u186615 data/Eurovision3.json data/Eurovision4.json data/Eurovision5.json data/Eurovision6.json data/Eurovision7.json data/Eurovision8.json data/Eurovision9.json data/Eurovision10.json 
Where the language is the language of the tweets we want to select and lsds2024.lab1.output.u186615 is the bucket where the files are uploaded to.

For the benchmarking, We used the currentTimeMillis function, in order to calculate the running time of the code in milliseconds. 
We did a substraction by calculating the running time at the beggining and at the end of the code. 
We performed the benchmark and counted the tweets for each language. 
- For spanish: 
Running time for tweets in spanish:
Processing: data/Eurovision3.json
Tweets processed in data/Eurovision3.json: 23848
Processing: data/Eurovision4.json
Tweets processed in data/Eurovision4.json: 78433
Processing: data/Eurovision5.json
Tweets processed in data/Eurovision5.json: 45800
Processing: data/Eurovision6.json
Tweets processed in data/Eurovision6.json: 71677
Processing: data/Eurovision7.json
Tweets processed in data/Eurovision7.json: 54969
Processing: data/Eurovision8.json
Tweets processed in data/Eurovision8.json: 38805
Processing: data/Eurovision9.json
Tweets processed in data/Eurovision9.json: 26244
Processing: data/Eurovision10.json
Tweets processed in data/Eurovision10.json: 169659
Total running time is: 49315 milliseconds
Total tweets processed in es are: 509435

- For english:
Running time for tweets in english:
Processing: data/Eurovision3.json
Tweets processed in data/Eurovision3.json: 24346
Processing: data/Eurovision4.json
Tweets processed in data/Eurovision4.json: 96430
Processing: data/Eurovision5.json
Tweets processed in data/Eurovision5.json: 50545
Processing: data/Eurovision6.json
Tweets processed in data/Eurovision6.json: 66596
Processing: data/Eurovision7.json
Tweets processed in data/Eurovision7.json: 39794
Processing: data/Eurovision8.json
Tweets processed in data/Eurovision8.json: 35569
Processing: data/Eurovision9.json
Tweets processed in data/Eurovision9.json: 18048
Processing: data/Eurovision10.json
Tweets processed in data/Eurovision10.json: 115275
Total running time is: 46379 milliseconds
Total tweets processed in en are: 446603

- For catalan:
Running time for tweets in catalan:
Processing: data/Eurovision3.json
Tweets processed in data/Eurovision3.json: 242
Processing: data/Eurovision4.json
Tweets processed in data/Eurovision4.json: 983
Processing: data/Eurovision5.json
Tweets processed in data/Eurovision5.json: 581
Processing: data/Eurovision6.json
Tweets processed in data/Eurovision6.json: 717
Processing: data/Eurovision7.json
Tweets processed in data/Eurovision7.json: 398
Processing: data/Eurovision8.json
Tweets processed in data/Eurovision8.json: 404
Processing: data/Eurovision9.json
Tweets processed in data/Eurovision9.json: 193
Processing: data/Eurovision10.json
Tweets processed in data/Eurovision10.json: 1065
Total running time is: 41704 milliseconds
Total tweets processed in ca are: 4583

We did not encounter issues to perform the calculation. 
# 6.- Extensions: TwitterFilterTest.java

The unit tests have been conducted using a few examples of tweets from the Eurovision 2018 collection, the following cases are checked:
- Processing a sample valid tweet containing the necessary data results in an Optional of type SimplifiedTweet
- Processing a json that is completly unrelated results in an empty optional
- Processing a sample (otherwise valid) tweet containing all the necessary attributes EXCEPT FOR 1 ('id') results in an empty optional.

These tests are checked at compile time, so maven makes sure automatically that they all pass before the application is ran. Were they to fail, no target folder would be generated.
