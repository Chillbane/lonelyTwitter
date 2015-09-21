package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/*
 * Created by cbli on 9/14/15.
 */
public abstract class CurrentMood {
    private Date date;

    public CurrentMood() {
        this.date = new Date();
    }

    public CurrentMood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String returnMessage();
}
