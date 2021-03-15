package com.example.pettrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class PetActivity extends AppCompatActivity {

    private static final String TAG = "PetActivity";
    private Button mBackButton;
    private SQLiteDatabase db;
    private Context mContext;


    private PetActivity(Context context){
        mContext = context.getApplicationContext();
        db = new DatabaseStorage(mContext)
                .getWritableDatabase();
    }

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