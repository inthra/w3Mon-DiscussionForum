package com.epicodus.discussionforum.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 7/11/16.
 */
@Parcel
public class Question {
    String postedQuestion;
    String username;
    List<Answer> answers = new ArrayList<>();

    public Question() {}

    public Question(String postedQuestion, String username, ArrayList<Answer> answers) {
        this.postedQuestion = postedQuestion;
        this.answers = answers;
    }

    public String getQuestion() {
        return postedQuestion;
    }

    public String getUsername() {
        return username;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
