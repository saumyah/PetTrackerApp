package com.example.pettrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
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
        setAlarm(context);
        setTime = findViewById(R.id.buttonTime);
        setTime.setOnClickListener(this);
        setAlarm = findViewById(R.id.buttonAlarm);
        setTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final int viewId = v.getId();
        if(viewId == R.id.buttonTime){
            calendar = Calendar.getInstance();
            currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            currentMinute = calendar.get(Calendar.MINUTE);

            timePicker = new TimePickerDialog(AlarmActivity.this, (timePicker, hourOfDay, minute) -> {
                hour.setText(String.format("%02d", hourOfDay));
                min.setText(String.format("%02d", minute));


            }, currentHour, currentMinute, false);

            timePicker.show();
        }
        if(viewId == R.id.buttonAlarm){
            if(!hour.getText().toString().isEmpty() && !min.getText().toString().isEmpty()) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(hour.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(min.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Time to feed your pet");
                startActivity(intent);
            }
            else{
                Toast.makeText(AlarmActivity.this, "Please choose a time", Toast.LENGTH_SHORT).show();
            }

        }

    }


    public void setAlarm(Context context)
    {
        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, AlarmActivity.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 60 * 10, pi); // Millisec * Second * Minute
    }

    public void cancelAlarm(Context context)
    {
        Intent intent = new Intent(context, AlarmActivity.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
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