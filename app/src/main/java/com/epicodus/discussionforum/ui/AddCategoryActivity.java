package com.epicodus.discussionforum.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.discussionforum.Constants;
import com.epicodus.discussionforum.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
            saveCategoryToFirebase(newCategory);
        }
    }

    public void saveCategoryToFirebase(String newCategory) {
        mCategoryReference.push().setValue(newCategory);
    }
}
