package com.epicodus.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.models.Category;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryQuestionsActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Category> mCategories = new ArrayList<>();
    @Bind(R.id.categoryTitle) TextView mCategoryTitle;
    @Bind(R.id.addQuestionButton) Button mAddQuestionButton;
    int startingPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_questions);
        ButterKnife.bind(this);

        mCategories = Parcels.unwrap(getIntent().getParcelableExtra("categories"));
        startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));

        Log.d("Category", mCategories.get(startingPosition).getTitle());
        Log.d("list, number", Integer.toString(startingPosition));

        mCategoryTitle.setText(mCategories.get(startingPosition).getTitle());

        mAddQuestionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mAddQuestionButton) {
            Intent intent = new Intent(CategoryQuestionsActivity.this, AddQuestionActivity.class);
            intent.putExtra("position", startingPosition + "");
            intent.putExtra("categories", Parcels.wrap(mCategories));
            startActivity(intent);
        }
    }
}
