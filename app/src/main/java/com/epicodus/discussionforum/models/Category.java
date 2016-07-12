package com.epicodus.discussionforum.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Category {
    String title;
    List<Question> questions = new ArrayList<>();
    String categoryId;

    public Category() {}

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

    public String getCategoryId() { return categoryId; }
}
