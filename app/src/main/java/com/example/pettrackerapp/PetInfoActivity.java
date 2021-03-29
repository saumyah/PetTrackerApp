package com.example.pettrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class PetInfoActivity extends AppCompatActivity {
    private static final String TAG = "PetInfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_info);
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