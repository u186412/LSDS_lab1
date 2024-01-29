package edu.upf;

import edu.upf.parser.SimplifiedTweet;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class TwitterFilterTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    //Unit test for SimplifiedTweet (additional point 6.1)
    @Test
    public void simplified_tweet_test() {
        //import sample tweet from eurovision dataset - valid tweet
        String testTweet1 = "{\"created_at\":\"Sat May 12 15:58:53 +0000 2018\",\"id\":995332494974210048,\"id_str\":\"995332494974210048\",\"text\":\"RT @carloscarmo98: -Manel, algo que decir sobre tu actuaci\\u00f3n en Eurovision?\\n-Kikiriketediga https:\\/\\/t.co\\/yXGYtKmJoM\",\"source\":\"\\u003ca href=\\\"http:\\/\\/twitter.com\\/download\\/android\\\" rel=\\\"nofollow\\\"\\u003eTwitter for Android\\u003c\\/a\\u003e\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":492271155,\"id_str\":\"492271155\",\"name\":\"alba aguirre\",\"screen_name\":\"Alba137\",\"location\":\"en pleno akelarre\",\"url\":null,\"description\":\"no todo lo que brilla es oro, a veces es highlight \\u2728\\ud83d\\udc9c\",\"translator_type\":\"regular\",\"protected\":false,\"verified\":false,\"followers_count\":718,\"friends_count\":416,\"listed_count\":2,\"favourites_count\":24718,\"statuses_count\":21764,\"created_at\":\"Tue Feb 14 14:46:34 +0000 2012\",\"utc_offset\":10800,\"time_zone\":\"Athens\",\"geo_enabled\":true,\"lang\":\"es\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"C0DEED\",\"profile_background_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_background_images\\/623739463202684928\\/vjeMtHPV.jpg\",\"profile_background_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_background_images\\/623739463202684928\\/vjeMtHPV.jpg\",\"profile_background_tile\":true,\"profile_link_color\":\"00B371\",\"profile_sidebar_border_color\":\"000000\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/992694287451217920\\/v3dvIg9N_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/992694287451217920\\/v3dvIg9N_normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/492271155\\/1516449879\",\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweeted_status\":{\"created_at\":\"Sat May 13 20:57:18 +0000 2017\",\"id\":863498411517108224,\"id_str\":\"863498411517108224\",\"text\":\"-Manel, algo que decir sobre tu actuaci\\u00f3n en Eurovision?\\n-Kikiriketediga https:\\/\\/t.co\\/yXGYtKmJoM\",\"display_text_range\":[0,72],\"source\":\"\\u003ca href=\\\"http:\\/\\/twitter.com\\/download\\/android\\\" rel=\\\"nofollow\\\"\\u003eTwitter for Android\\u003c\\/a\\u003e\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":1651197529,\"id_str\":\"1651197529\",\"name\":\"Carlos Carmona\",\"screen_name\":\"carloscarmo98\",\"location\":\"Logro\\u00f1o, Espa\\u00f1a\",\"url\":null,\"description\":\"Estudiante de Geograf\\u00eda e Historia y seguidor del Valencia C.F. Nacido en Villanueva de la Serena, Extremadura, y viviendo en Logro\\u00f1o\",\"translator_type\":\"none\",\"protected\":false,\"verified\":false,\"followers_count\":155,\"friends_count\":108,\"listed_count\":0,\"favourites_count\":1100,\"statuses_count\":1857,\"created_at\":\"Tue Aug 06 20:28:56 +0000 2013\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":false,\"lang\":\"es\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"C0DEED\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_tile\":false,\"profile_link_color\":\"1DA1F2\",\"profile_sidebar_border_color\":\"C0DEED\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/924184485771522048\\/MGfUXALI_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/924184485771522048\\/MGfUXALI_normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/1651197529\\/1498818908\",\"default_profile\":true,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"is_quote_status\":false,\"quote_count\":63,\"reply_count\":17,\"retweet_count\":2945,\"favorite_count\":2568,\"entities\":{\"hashtags\":[],\"urls\":[],\"user_mentions\":[],\"symbols\":[],\"media\":[{\"id\":863498400314126342,\"id_str\":\"863498400314126342\",\"indices\":[73,96],\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/C_vDOFbXcAYRKXK.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/C_vDOFbXcAYRKXK.jpg\",\"url\":\"https:\\/\\/t.co\\/yXGYtKmJoM\",\"display_url\":\"pic.twitter.com\\/yXGYtKmJoM\",\"expanded_url\":\"https:\\/\\/twitter.com\\/carloscarmo98\\/status\\/863498411517108224\\/photo\\/1\",\"type\":\"photo\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"small\":{\"w\":680,\"h\":519,\"resize\":\"fit\"},\"medium\":{\"w\":1078,\"h\":823,\"resize\":\"fit\"},\"large\":{\"w\":1078,\"h\":823,\"resize\":\"fit\"}}}]},\"extended_entities\":{\"media\":[{\"id\":863498400314126342,\"id_str\":\"863498400314126342\",\"indices\":[73,96],\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/C_vDOFbXcAYRKXK.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/C_vDOFbXcAYRKXK.jpg\",\"url\":\"https:\\/\\/t.co\\/yXGYtKmJoM\",\"display_url\":\"pic.twitter.com\\/yXGYtKmJoM\",\"expanded_url\":\"https:\\/\\/twitter.com\\/carloscarmo98\\/status\\/863498411517108224\\/photo\\/1\",\"type\":\"photo\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"small\":{\"w\":680,\"h\":519,\"resize\":\"fit\"},\"medium\":{\"w\":1078,\"h\":823,\"resize\":\"fit\"},\"large\":{\"w\":1078,\"h\":823,\"resize\":\"fit\"}}}]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"filter_level\":\"low\",\"lang\":\"es\"},\"is_quote_status\":false,\"quote_count\":0,\"reply_count\":0,\"retweet_count\":0,\"favorite_count\":0,\"entities\":{\"hashtags\":[],\"urls\":[],\"user_mentions\":[{\"screen_name\":\"carloscarmo98\",\"name\":\"Carlos Carmona\",\"id\":1651197529,\"id_str\":\"1651197529\",\"indices\":[3,17]}],\"symbols\":[],\"media\":[{\"id\":863498400314126342,\"id_str\":\"863498400314126342\",\"indices\":[92,115],\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/C_vDOFbXcAYRKXK.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/C_vDOFbXcAYRKXK.jpg\",\"url\":\"https:\\/\\/t.co\\/yXGYtKmJoM\",\"display_url\":\"pic.twitter.com\\/yXGYtKmJoM\",\"expanded_url\":\"https:\\/\\/twitter.com\\/carloscarmo98\\/status\\/863498411517108224\\/photo\\/1\",\"type\":\"photo\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"small\":{\"w\":680,\"h\":519,\"resize\":\"fit\"},\"medium\":{\"w\":1078,\"h\":823,\"resize\":\"fit\"},\"large\":{\"w\":1078,\"h\":823,\"resize\":\"fit\"}},\"source_status_id\":863498411517108224,\"source_status_id_str\":\"863498411517108224\",\"source_user_id\":1651197529,\"source_user_id_str\":\"1651197529\"}]},\"extended_entities\":{\"media\":[{\"id\":863498400314126342,\"id_str\":\"863498400314126342\",\"indices\":[92,115],\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/C_vDOFbXcAYRKXK.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/C_vDOFbXcAYRKXK.jpg\",\"url\":\"https:\\/\\/t.co\\/yXGYtKmJoM\",\"display_url\":\"pic.twitter.com\\/yXGYtKmJoM\",\"expanded_url\":\"https:\\/\\/twitter.com\\/carloscarmo98\\/status\\/863498411517108224\\/photo\\/1\",\"type\":\"photo\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"small\":{\"w\":680,\"h\":519,\"resize\":\"fit\"},\"medium\":{\"w\":1078,\"h\":823,\"resize\":\"fit\"},\"large\":{\"w\":1078,\"h\":823,\"resize\":\"fit\"}},\"source_status_id\":863498411517108224,\"source_status_id_str\":\"863498411517108224\",\"source_user_id\":1651197529,\"source_user_id_str\":\"1651197529\"}]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"filter_level\":\"low\",\"lang\":\"es\",\"timestamp_ms\":\"1526140733842\"}";
        Optional<SimplifiedTweet> optional_testTweet1 = SimplifiedTweet.fromJson(testTweet1);
        assertTrue(optional_testTweet1.isPresent()); //should be non-empty optional

        //parsing invalid json test - unrelated data
        String testTweet2 = "{\"name\":\"John\", \"age\":30, \"car\":null}";
        Optional<SimplifiedTweet> optional_testTweet2 = SimplifiedTweet.fromJson(testTweet2);
        assertEquals(optional_testTweet2, Optional.empty()); //should be empty optional

        //parsing valid json with missing 'id' field
        String testTweet3 = "{\"created_at\":\"Sat May 12 15:58:54 +0000 2018\",\"text\":\"Eurovision song contest 2018 tonight!!!!!!\",\"source\":\"\\u003ca href=\\\"http:\\/\\/twitter.com\\/download\\/android\\\" rel=\\\"nofollow\\\"\\u003eTwitter for Android\\u003c\\/a\\u003e\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":912957841,\"id_str\":\"912957841\",\"name\":\"Astrid \\/\\/ \\u30a8\\u30ea\\u30fc\",\"screen_name\":\"666asstrid\",\"location\":\"Norway\",\"url\":\"http:\\/\\/instagram.com\\/astridbrevik\",\"description\":\"\\u79c1\\u306f\\u30ce\\u30eb\\u30a6\\u30a7\\u30fc\\u4eba\\u3067\\u3059\\u3002                                                         \\n\\u6211\\u5728\\u5b66\\u4e2d\\u6587\\n\\ud83c\\udde8\\ud83c\\uddf3\\ud83c\\udde9\\ud83c\\uddea\\ud83c\\uddef\\ud83c\\uddf5\\ud83c\\uddf0\\ud83c\\uddf7\\ud83c\\uddf3\\ud83c\\uddf4\",\"translator_type\":\"none\",\"protected\":false,\"verified\":false,\"followers_count\":451,\"friends_count\":154,\"listed_count\":5,\"favourites_count\":1830,\"statuses_count\":1079,\"created_at\":\"Mon Oct 29 18:11:20 +0000 2012\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":true,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"000000\",\"profile_background_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_background_images\\/754309720\\/5e8cbae2811263a5d6110f0b1b41c402.jpeg\",\"profile_background_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_background_images\\/754309720\\/5e8cbae2811263a5d6110f0b1b41c402.jpeg\",\"profile_background_tile\":true,\"profile_link_color\":\"1B95E0\",\"profile_sidebar_border_color\":\"FFFFFF\",\"profile_sidebar_fill_color\":\"FFFFFF\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/965300035683528704\\/lJmd_4fw_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/965300035683528704\\/lJmd_4fw_normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/912957841\\/1474389266\",\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"is_quote_status\":false,\"quote_count\":0,\"reply_count\":0,\"retweet_count\":0,\"favorite_count\":0,\"entities\":{\"hashtags\":[],\"urls\":[],\"user_mentions\":[],\"symbols\":[]},\"favorited\":false,\"retweeted\":false,\"filter_level\":\"low\",\"lang\":\"en\",\"timestamp_ms\":\"1526140734600\"}";
        Optional<SimplifiedTweet> optional_testTweet3 = SimplifiedTweet.fromJson(testTweet3);
        assertEquals(optional_testTweet3, Optional.empty()); //should be empty optional
    }
}
