package com.epicodus.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.epicodus.discussionforum.Constants;
import com.epicodus.discussionforum.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mCategoryReference;
    @Bind(R.id.addCategoryButton)
    Button mAddCategoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mCategoryReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_CATEGORY);

        mCategoryReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot categorySnapshot : dataSnapshot.getChildren()) {
                    String category = categorySnapshot.getValue().toString();
                    Log.d("Categories updated", "category: " + category);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAddCategoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mAddCategoryButton) {
            Intent intent = new Intent(MainActivity.this, AddCategoryActivity.class);
            startActivity(intent);
        }
    }
}
