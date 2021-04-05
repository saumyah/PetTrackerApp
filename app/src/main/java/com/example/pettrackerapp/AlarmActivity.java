package com.example.pettrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "AlarmActivity";
    private AlarmManager am;
    private Context context;
    private TimePickerDialog timePicker;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    Button setTime;
    Button setAlarm;
    EditText hour;
    EditText min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        setTime = findViewById(R.id.buttonTime);
        setTime.setOnClickListener(this);
        setAlarm = findViewById(R.id.buttonAlarm2);
        setTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final int viewId = v.getId();
        if(viewId == R.id.buttonBack2){
            finish();
        }
        if(viewId == R.id.buttonTime){
            calendar = Calendar.getInstance();
            currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            currentMinute = calendar.get(Calendar.MINUTE);

            timePicker = new TimePickerDialog(AlarmActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hour.setText(String.format("%02d", hourOfDay));
                    min.setText(String.format("%02d", minute));
                }
            }, currentHour, currentMinute, false);

            timePicker.show();
        }
        if(viewId == R.id.buttonAlarm2){
            if(!hour.getText().toString().isEmpty() && !min.getText().toString().isEmpty()) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(hour.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(min.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Time to feed your pet");
                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }else{
                    Toast.makeText(AlarmActivity.this, "No Supporting Apps", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(AlarmActivity.this, "Please choose a time", Toast.LENGTH_SHORT).show();
            }

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