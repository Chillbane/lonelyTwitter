package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cbli on 9/14/15.\
 *
 * Don't want to allow someone to go tweet.text = ""  -> force them to call a method instead
 */
// Implied: public class Tweet extends Object
public abstract class Tweet {
    protected String text;
    private Date date;
    List<String> moodList = new ArrayList<String>();

    public Tweet(String text, Date date) {
        //implied: super() -> takes no attributes

        // this.text refers to text attribute declared above
        // text refers to text variable in argument
        this.text = text;
        this.date = date;
    }

    public Tweet(String text) {
        this.text = text;
        // don't need to do this.date b/c no date variable in argument
        date = new Date(); // make new Date object by calling its constructor (default: current date)
    }

    public String getText() {
        return text;
    }

    /* dot operator:
     *  - x.y in java is basically x-> in C
     */

    public void setText(String text) throws IOException {
        // limit tweet to 140 characters
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new IOException("Tweet was too long!");
        }
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // every kind of tweet needs to have an isImportant, but we don't know what the method does
    // until told what class it is
    public abstract Boolean isImportant();
}
