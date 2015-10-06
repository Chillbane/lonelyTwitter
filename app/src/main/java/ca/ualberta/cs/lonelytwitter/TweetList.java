package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Observer;

/**
 * Created by joshua2 on 9/28/15.
 */
public class TweetList implements MyObservable, MyObserver {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();  // model

    // volatile -> tells GSON not to save list of Observers
    // only keeping list for runtime information -> not for saving
    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>(); // model

    // View
    private void notifyAllObservers() {
        for (MyObserver observer : observers) {

            // customary to provide observer with who's calling it
            observer.myNotify(this);
        }
    }

    public void add(Tweet tweet) { //controller
        tweets.add(tweet);
        tweet.addObserver(this);
        notifyAllObservers();
    }

    // controller
    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }


    public Boolean contains(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public void addObserver(MyObserver observer) {
        this.observers.add(observer);
    }


    /* Following code to make it an observer */
    public void myNotify(MyObservable observable) {
        notifyAllObservers();
    }

}
