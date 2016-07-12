package com.epicodus.discussionforum.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 7/11/16.
 */
@Parcel
public class Question {
    String question;
    String username;
    List<Answer> answers = new ArrayList<>();

    public Question() {}
}
