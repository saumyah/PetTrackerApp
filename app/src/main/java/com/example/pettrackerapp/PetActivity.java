package com.example.pettrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PetActivity extends AppCompatActivity {

    private static final String TAG = "PetActivity";
    private Button mBackButton;
    private Context mContext;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);
        mBackButton = (Button) findViewById(R.id.buttonBack2);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mTextView = findViewById(R.id.textView2);

        DatabaseStorage db = new DatabaseStorage(this);

        db.createPet("Spot", "Dog");
        db.createPet("Tabby","Cat");
        db.createPet("Blue","Bird");

        String petName1 = db.retrieveEntry(1);
        String petName2 = db.retrieveEntry(2);
        String petName3 = db.retrieveEntry(3);

        mTextView.setText(petName1 + " " + petName2 + " " + petName3);
    }

    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()");
    }
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume()");
    }
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy()");
    }
}