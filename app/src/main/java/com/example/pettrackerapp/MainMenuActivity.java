package com.example.pettrackerapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import timber.log.Timber;

public class MainMenuActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView((R.layout.fragment_game_options));
    }

    protected Fragment createFragment() {
        return new MainMenuFragment();
    }

}
