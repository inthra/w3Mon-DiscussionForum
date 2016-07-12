package com.epicodus.discussionforum.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.models.Category;

import org.parceler.Parcels;

import java.util.ArrayList;

public class CategoryQuestionsActivity extends AppCompatActivity {
    ArrayList<Category> mCategories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_questions);

        mCategories = Parcels.unwrap(getIntent().getParcelableExtra("restaurants"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
    }
}
