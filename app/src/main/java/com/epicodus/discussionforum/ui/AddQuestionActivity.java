package com.epicodus.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.discussionforum.Constants;
import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.models.Answer;
import com.epicodus.discussionforum.models.Category;
import com.epicodus.discussionforum.models.Question;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddQuestionActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mQuestionReference;

    @Bind(R.id.questionInput) EditText mQuestionInput;
    @Bind(R.id.usernameInput) EditText mUsernameInput;
    @Bind(R.id.addQuestionButton) Button mAddQuestionButton;

    ArrayList<Category> mCategories = new ArrayList<>();
    int startingPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mQuestionReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_CATEGORY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        ButterKnife.bind(this);

        mCategories = Parcels.unwrap(getIntent().getParcelableExtra("categories"));
        startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));

        mAddQuestionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mAddQuestionButton) {
            String newQuestion = mQuestionInput.getText().toString();
            String newUsername = mUsernameInput.getText().toString();
            Question question = new Question(newQuestion, newUsername, new ArrayList<Answer>());
            saveQuestionToFirebase(question);

            Intent intent = new Intent(AddQuestionActivity.this, CategoryQuestionsActivity.class);
            startActivity(intent);
        }
    }
    public void saveQuestionToFirebase(Question question) {
        String id = mCategories.get(startingPosition).getCategoryId();
        Log.d("category id", id);
        mQuestionReference.push().setValue(question);
    }
}
