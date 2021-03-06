package com.example.pettrackerapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
//import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainMenuActivity extends Activity {

    private static final String TAG = "MainMenuActivity";
    private Button mHelpButton;
    private Button mPetsButton;
    private Button mPetInfoButton;
    private Button mAlarmButton;
    private Button mMapButton;
    private Button mExitButton;
    private Button mSettingsButton;
    private Button refreshButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView((R.layout.fragment_game_options));
        // Change activity based on which button was pressed
        mHelpButton = (Button) findViewById(R.id.buttonHelp);
        mHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });
        refreshButton = (Button) findViewById(R.id.buttonRefresh2);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        mSettingsButton = (Button) findViewById(R.id.buttonSettings);
        mSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, SettingsActivity.class);
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
        mPetInfoButton = (Button) findViewById(R.id.buttonPetInfo);
        mPetInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, PetInfoActivity.class);
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
        mMapButton = (Button) findViewById(R.id.buttonMaps);
        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
        mExitButton = (Button) findViewById(R.id.buttonExit);
        mExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDatabase("PetsDatabase");
                finish();
            }
        });
    }



    public void onStart() {
                super.onStart();
                Log.d(TAG, "onStart()");
            }

            public void onResume() {
                super.onResume();
                Log.d(TAG, "onResume()");
            }

            public void onPause() {
                super.onPause();
                Log.d(TAG, "onPause()");
            }

            @Override
            public void onStop() {
                super.onStop();
                Log.d(TAG, "onStop()");
            }

            @Override
            public void onDestroy() {
                super.onDestroy();
                Log.d(TAG, "onDestroy()");
            }

}
