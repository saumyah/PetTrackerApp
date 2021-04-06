package com.example.pettrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class PetActivity extends AppCompatActivity  implements View.OnClickListener{

    private static final String TAG = "PetActivity";
    private Button mBackButton;
    private Button mRefresh;
    private TextView mTextView;
    private DatabaseStorage db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.deleteDatabase("PetsDatabase");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);
        mBackButton = (Button) findViewById(R.id.buttonBack2);
        mBackButton.setOnClickListener(this);
        mRefresh = (Button) findViewById(R.id.buttonRefresh);
        mRefresh.setOnClickListener(this);
        mTextView = findViewById(R.id.textView2);
//        File databasePath = getDatabasePath("PetsDatabase");
//        SQLiteDatabase sql = SQLiteDatabase.openDatabase(databasePath.getAbsolutePath(), null, SQLiteDatabase.OPEN_READWRITE);

        db = new DatabaseStorage(this);
    }


    @Override
    public void onClick(View v) {
        final int viewId = v.getId();
        // Check which button is being clicked
        if(viewId == R.id.buttonBack2){
            finish();
        }
        if(viewId == R.id.buttonRefresh){
            mTextView.setText(db.getDatabaseName());
        }
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