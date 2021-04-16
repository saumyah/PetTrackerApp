package com.example.pettrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class PetInfoActivity extends AppCompatActivity {
    private static final String TAG = "PetInfoActivity";
    private EditText mPetName;
    private EditText mPetType;
    private EditText mPetAge;
    private EditText mPetSex;
    private EditText mPetWeight;
    private Button mSubmitButton;
    private DatabaseStorage db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_pet_info);
        db = DatabaseStorage.getInstance(this);

        mPetName =(EditText)findViewById(R.id.pet_name_input);
        mPetType =(EditText)findViewById(R.id.pet_type_input);
        mPetAge =(EditText)findViewById(R.id.pet_age_input);
        mPetSex =(EditText)findViewById(R.id.pet_sex_input);
        mPetWeight =(EditText)findViewById(R.id.pet_weight_input);

        mSubmitButton = (Button) findViewById(R.id.buttonSubmit);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,
                        "\nName: " + mPetName.getText()
                                + "\nType: " + mPetType.getText()
                                + "\nAge: " + mPetAge.getText()
                                + "\nSex: " + mPetSex.getText()
                                + "\nWeight: " + mPetWeight.getText()
                );

                db.createPet(mPetName.getText().toString(),
                        mPetType.getText().toString(),
                        Integer.parseInt(mPetAge.getText().toString()), mPetSex.getText().toString(), Integer.parseInt(mPetWeight.getText().toString())
                        );

                mPetName.setText(R.string.name_input);
                mPetType.setText(R.string.type_input);
                mPetAge.setText(R.string.age_input);
                mPetSex.setText(R.string.sex_input);
                mPetWeight.setText(R.string.weight_input);
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