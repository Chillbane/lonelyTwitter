package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/**
 * Created by joshua2 on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 implements MyObserver {
    private Boolean wasNotified = Boolean.FALSE;

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void myNotify(MyObservable observable) {
        wasNotified = Boolean.TRUE; //record it was called
    }

    public void testAddObserver() {
        TweetList list = new TweetList();
        list.addObserver(this);
        wasNotified = Boolean.FALSE;
        list.add(new NormalTweet("test"));
        // at this point we expect to be modfied
        assertTrue(wasNotified);
    }

    public void testTweetObserver() {
        TweetList list = new TweetList();
        list.addObserver(this);

        // Add tweet to it
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        wasNotified = Boolean.FALSE;

        // Change content of tweet -> still want to be notified
        // 1) Make Tweet observable
        // 2) Make TweetList an observer
        tweet.setText("different");
    }

    public void testAddTweet() {
        TweetList list = new TweetList();
        list.add(new NormalTweet("test"));
    }

    public void testDelete() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        list.delete(tweet);
        assertFalse(list.contains(tweet));
    }

    public void testContains() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.contains(tweet));
    }
}