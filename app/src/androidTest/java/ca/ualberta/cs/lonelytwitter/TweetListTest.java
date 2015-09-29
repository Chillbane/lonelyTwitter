package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import java.util.ArrayList;
import junit.framework.TestCase;

/**
 * Created by cbli on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();
        list.add(new NormalTweet("test"));
    }

    public void testAddDuplicateTweet() {
        TweetList list = new TweetList();
        list.add(new NormalTweet("test"));
        Boolean exception_caught = false;

        try {
            list.add(new NormalTweet("test"));
        }catch (IllegalArgumentException e) {
            exception_caught = true;
        }
        assertTrue(exception_caught == true);
    }

    public void testRemoveTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        list.remove(tweet);
        assertFalse(list.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweets() {
        TweetList list = new TweetList();
        Tweet first_tweet = new NormalTweet("c");
        Tweet second_tweet = new NormalTweet("b");
        Tweet third_tweet = new NormalTweet("a");

        list.add(first_tweet);
        list.add(second_tweet);
        list.add(third_tweet);

        assertTrue(list.isSorted() == true);

    }

    public void testGetCount() {
        TweetList list = new TweetList();
        int count = 3;

        Tweet first_tweet = new NormalTweet("c");
        Tweet second_tweet = new NormalTweet("b");
        Tweet third_tweet = new NormalTweet("a");

        list.add(first_tweet);
        list.add(second_tweet);
        list.add(third_tweet);

        assertTrue(list.getCount() == 3);
    }




}