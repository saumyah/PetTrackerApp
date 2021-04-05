package com.example.pettrackerapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import android.widget.TextView;
import timber.log.Timber;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SettingsActivity";
    private Button mBackButton;
    private Button mDeleteButton;
    DatabaseStorage db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.deleteDatabase("PetsDatabase");
        super.onCreate(savedInstanceState);
        //Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_settings);
        mBackButton = (Button) findViewById(R.id.buttonBack);
        mBackButton.setOnClickListener(this);
        mDeleteButton = (Button) findViewById(R.id.buttonDelete);
        mDeleteButton.setOnClickListener(this);
        //db = new DatabaseStorage(this);
    }
    @Override
    public void onClick(View v) {
        final int viewId = v.getId();
        if(viewId == R.id.buttonBack){
            finish();
        }
        if(viewId == R.id.buttonDelete){
            this.deleteDatabase("PetsDatabase");
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

