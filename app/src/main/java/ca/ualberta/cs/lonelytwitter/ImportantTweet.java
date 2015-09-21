package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/*
 * Created by cbli on 9/14/15.
 */
public class ImportantTweet extends Tweet {
    public ImportantTweet(String tweet, Date date){
        // super calls constructor of parent/super class
        super(tweet, date);
    }

    public ImportantTweet(String text) throws IOException {
        super(text);
        this.text = (text); // can only access if text in superclass is protected (not private)
        // equivalent to this .setText(text);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
