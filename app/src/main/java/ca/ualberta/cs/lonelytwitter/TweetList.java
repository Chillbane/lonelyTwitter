package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

import ca.ualberta.cs.lonelytwitter.Tweet;

/**
 * Created by cbli on 9/28/15.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        for(int i=0; i < tweets.size(); i++){
            if (tweets.get(i) == tweet) {
                throw new IllegalArgumentException("duplicate keys not allowed");
            }
        }
        tweets.add(tweet);
    }

    public void remove(Tweet tweet) {
        tweets.remove(tweet);
    }

    public Boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Boolean isSorted() {
        return false;
    }

    public int getCount() {
        return tweets.size();
    }
}
