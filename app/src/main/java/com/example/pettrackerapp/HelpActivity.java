package com.example.pettrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import timber.log.Timber;

public class HelpActivity extends AppCompatActivity {

    private Button mBackButton;
    private static final String TAG = "HelpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate()");
        setContentView(R.layout.activity_help);
        mBackButton = (Button) findViewById(R.id.buttonBack);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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