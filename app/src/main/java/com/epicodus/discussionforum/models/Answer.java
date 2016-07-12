package com.epicodus.discussionforum.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 7/11/16.
 */
@Parcel
public class Answer {
    String postedAnswer;
    String username;

    public Answer() {}

    public Answer(String postedAnswer, String username) {
        this.postedAnswer = postedAnswer;
        this.username = username;
    }

    public String getAnswer() {
        return postedAnswer;
    }

    public String getUsername() {
        return username;
    }
}
