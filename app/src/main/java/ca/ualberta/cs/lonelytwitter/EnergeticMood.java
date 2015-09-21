package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/*
 * Created by cbli on 9/14/15.
 */
public class EnergeticMood extends CurrentMood {

    public EnergeticMood() {
        super();
    }

    public EnergeticMood(Date date) {
        super(date);
    }

    public String returnMessage() {
        return "Ready for a marathon.";
    }
}
