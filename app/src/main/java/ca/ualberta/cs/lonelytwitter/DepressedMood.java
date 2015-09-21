package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/*
 * Created by cbli on 9/14/15.
 */
public class DepressedMood extends CurrentMood {

    public DepressedMood() {
        super();
    }

    public DepressedMood(Date date) {
        super(date);
    }

    public String returnMood() {
       return "Depressed";
    }
}
