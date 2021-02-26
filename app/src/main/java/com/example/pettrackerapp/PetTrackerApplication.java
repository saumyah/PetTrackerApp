package com.example.pettrackerapp;

import android.app.Application;

import timber.log.Timber;

public class PetTrackerApplication extends Application{
        @Override
        public void onCreate() {
            super.onCreate();
            if (BuildConfig.DEBUG) {
                Timber.plant(new Timber.DebugTree());
            }
        }
}
