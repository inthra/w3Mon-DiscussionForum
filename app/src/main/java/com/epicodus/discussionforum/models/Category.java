package com.epicodus.discussionforum.models;

import java.util.ArrayList;
import java.util.List;

public class Category {
    String title;
    List<Question> questions = new ArrayList<>();

    public Category(String title, ArrayList<Question> questions) {
        this.title = title;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
