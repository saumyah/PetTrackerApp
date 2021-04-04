package com.example.pettrackerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import timber.log.Timber;

public class MainMenuActivity extends Activity {

    private static final String TAG = "MainMenuActivity";
    private Button mHelpButton;
    private Button mPetsButton;
    private Button mAlarmButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView((R.layout.fragment_game_options));
        mHelpButton = (Button) findViewById(R.id.buttonHelp);
        mHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });
        mPetsButton = (Button) findViewById(R.id.buttonPets);
        mPetsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, PetActivity.class);
                startActivity(intent);
            }
        });
        mAlarmButton = (Button) findViewById(R.id.buttonAlarm2);
        mAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, AlarmActivity.class);
                startActivity(intent);
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
        Timber.d("onResume()");
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
