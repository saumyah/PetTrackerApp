package com.example.pettrackerapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import timber.log.Timber;

public class MainMenuFragment extends Fragment {

    private ViewGroup mContainer;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Timber.d("onCreateView()");
        View v;

        Activity activity = requireActivity();
        int rotation = activity.getDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            v = inflater.inflate(R.layout.fragment_game_options, container, false);
        } else {
            v = inflater.inflate(R.layout.fragment_game_options, container, false);
        }

        mContainer = container;
        setRetainInstance(true);

        return v;
    }

    @Override
    public void onStop() {
        super.onStop();
        Timber.d("onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Timber.d("onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.d("onDestroy()");
    }
}
