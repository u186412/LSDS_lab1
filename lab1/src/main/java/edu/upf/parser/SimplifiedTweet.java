package edu.upf.parser;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Optional;

public class SimplifiedTweet {

  // All classes use the same instance
  //private static JsonParser parser = new JsonParser();



  private final long tweetId;			  // the id of the tweet ('id')
  private final String text;  		      // the content of the tweet ('text')
  private final long userId;			  // the user id ('user->id')
  private final String userName;		  // the user name ('user'->'name')
  private final String language;          // the language of a tweet ('lang')
  private final long timestampMs;		  // seconduserIds from epoch ('timestamp_ms')

  public SimplifiedTweet(long tweetId, String text, long userId, String userName,
                         String language, long timestampMs) {

    // Class constructor --> assign attributes to given values.
    this.tweetId = tweetId;
    this.text = text;
    this.userId = userId;
    this.userName = userName;
    this.language = language;
    this.timestampMs = timestampMs;
  }

  /**
   * Returns a {@link SimplifiedTweet} from a JSON String.
   * If parsing fails, for any reason, return an {@link Optional#empty()}
   *
   * @param jsonStr
   * @return an {@link Optional} of a {@link SimplifiedTweet}
   */
  public static Optional<SimplifiedTweet> fromJson(String jsonStr) {
    // PLACE YOUR CODE HERE!
    Gson gson = new Gson(); //to use gson library functions
    JsonObject json = gson.fromJson(jsonStr, JsonObject.class); //parse string to JsonObject
    if (json != null) { //jsonStr is formatted correctly --> check it has necessary attributes
      //extract all 'simplified' attributes. If json does not contain the attribute they will be null or -1.
      long tweetId = json.has("id") ? json.get("id").getAsLong() : -1;
      String text = json.has("text") ? json.get("text").getAsString() : null;
      long userId = (json.has("user") && json.getAsJsonObject("user").has("id")) ? json.getAsJsonObject("user").get("id").getAsLong() : -1;
      String userName = (json.has("user") && json.getAsJsonObject("user").has("name")) ? json.getAsJsonObject("user").get("name").getAsString() : null;
      String language = json.has("lang") ? json.get("lang").getAsString() : null;
      long timestampMs = json.has("timestamp_ms") ? json.get("timestamp_ms").getAsLong() : -1;
      //construct Optional of the tweet
      if (tweetId != -1 && userId != -1 && timestampMs != -1) {
        Optional<SimplifiedTweet> tweet = Optional.ofNullable(tweetId)
                .flatMap(txt -> Optional.ofNullable(text))
                .flatMap(uId -> Optional.ofNullable(userId))
                .flatMap(uName -> Optional.ofNullable(userName))
                .flatMap(lang -> Optional.ofNullable(language))
                .flatMap(tstmp -> Optional.ofNullable(timestampMs))
                .map(twt -> new SimplifiedTweet(tweetId, text, userId, userName, language, timestampMs));
        return tweet; //returns Optional.empty() if some String field was null
      }
      else { //missing some long value --> return empty optional value
        return Optional.empty();
      }
    }
    else { //passed jsonStr formatted incorrectly --> return empty optional value
      return Optional.empty();
    }
  }

 public String getLanguage(){
    return this.language;
  }
  
  @Override
  public String toString() {
    return new Gson().toJson(this);
  }

}
