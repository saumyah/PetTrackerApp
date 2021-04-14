package com.example.pettrackerapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;


public class SettingsActivity extends AppCompatActivity {

    private Button mLangButton;
    private Button mBackButton;
    private static final String TAG = "SettingsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        Log.d(TAG,"onCreate()");
        setContentView(R.layout.activity_settings);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        mBackButton = (Button) findViewById(R.id.buttonBack);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mLangButton = (Button) findViewById(R.id.buttonLang);
        mLangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage();
            }
        });
    }

    private void changeLanguage() {
        final String[] list = {"English", "Spanish"};
        AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
        builder.setTitle("Choose a language");
        builder.setSingleChoiceItems(list, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == 0){
                    setLocale("en");
                    recreate();
                }
                else if(which == 1){
                    setLocale("es");
                    recreate();
                }

                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void setLocale(String sp) {

        Locale locale = new Locale(sp);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang", sp);
        editor.apply();
    }

    private void loadLocale(){
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = sharedPreferences.getString("My_Lang","");
        setLocale(language);
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