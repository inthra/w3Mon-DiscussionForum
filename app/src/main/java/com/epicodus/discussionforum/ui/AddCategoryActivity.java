package com.epicodus.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.discussionforum.Constants;
import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.models.Category;
import com.epicodus.discussionforum.models.Question;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddCategoryActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mCategoryReference;

    @Bind(R.id.addCategoryButton) Button mAddCategoryButton;
    @Bind(R.id.categoryNameInput) EditText mCategoryNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mCategoryReference = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_CATEGORY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        ButterKnife.bind(this);

        mAddCategoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mAddCategoryButton) {
            String newCategory = mCategoryNameInput.getText().toString();
            Category category = new Category(newCategory, new ArrayList<Question>());
            saveCategoryToFirebase(category);

            Intent intent = new Intent(AddCategoryActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void saveCategoryToFirebase(Category newCategory) {
        mCategoryReference.push().setValue(newCategory);
    }
}
